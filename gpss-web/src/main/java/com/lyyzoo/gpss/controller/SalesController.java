package com.lyyzoo.gpss.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpss.common.utils.BeanUtils;
import com.gpss.common.utils.Excel2003Utils;
import com.lyyzoo.gpss.api.service.IClientService;
import com.lyyzoo.gpss.api.service.IGoodsService;
import com.lyyzoo.gpss.api.service.ISalesOrderService;
import com.lyyzoo.gpss.api.service.IStorageService;
import com.lyyzoo.gpss.api.service.ISupplierService;
import com.lyyzoo.gpss.api.vo.Client;
import com.lyyzoo.gpss.api.vo.SalesOrder;
import com.lyyzoo.gpss.api.vo.StorageRecord;
import com.lyyzoo.gpss.api.vo.Supplier;

@RequestMapping("/sales")
@Controller
public class SalesController extends AbstractController{

	@Resource
	private ISalesOrderService salesOrderService;
	@Resource
	private ISupplierService supplierService;
	@Resource
	private IStorageService storageService;
	@Resource
	private IGoodsService goodsService;
	@Resource
	private IClientService clientService;
	
	@ResponseBody
	@RequestMapping(value ="/sales_orders", method = RequestMethod.GET)
	public Object getSalesOrders(Integer pageSize , Long currentPage, SalesOrder salesOrder) {
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> params = BeanUtils.beanToMap(salesOrder);
		map.put("total", salesOrderService.getSalesOrdersCount(params));
		List<SalesOrder> list = salesOrderService.getSalesOrders(params, pageSize, currentPage);
		map.put("rows", list);
		return map;
	}
	
	   @RequestMapping(value = "/sales_orders/output_data", method = RequestMethod.GET)
	    public void downLoadExcel(int pageSize , Long currentPage, SalesOrder salesOrder,HttpServletRequest request, HttpServletResponse response) throws IOException{
		   String sheetName = "销售订单数据";
	        String sheetTitle = "销售订单数据";
	        String fileName = "销售订单报表.xls";
	        response.setHeader("Content-disposition", "attachment;filename="
	        		+ new String(fileName.getBytes("gb2312"), "ISO8859-1"));//设置文件头编码格式
	        response.setContentType("APPLICATION/OCTET-STREAM;charset=UTF-8");//设置类型
	        response.setHeader("Cache-Control", "no-cache");//设置头
	        response.setDateHeader("Expires", 0);//设置日期头
	        List<String> columnNames = new LinkedList<>();
	        columnNames.add("订单id");
	        columnNames.add("商品名称");
	        columnNames.add("商品规格");
	        columnNames.add("供应商");
	        columnNames.add("客户名称");
	        columnNames.add("仓库");
	        columnNames.add("数量");
	        columnNames.add("单价");
	        columnNames.add("总价");
	        columnNames.add("审核状态");
	        columnNames.add("创建时间");
	        columnNames.add("出库时间");
			Map<String,Object> map = new HashMap<String,Object>();
			Map<String,Object> params = BeanUtils.beanToMap(salesOrder);
			List<SalesOrder> list = salesOrderService.getSalesOrders(params, pageSize, currentPage);
			map.put("rows", list);
		        List<List<Object>> objects = new LinkedList<>();
		        for (int i = 0; i < list.size(); i++) {
		            List<Object> dataA = new LinkedList<>();
		            SalesOrder so = list.get(i);
		            dataA.add(so.getSoid());
		            dataA.add(so.getGname());
		            dataA.add(so.getGsname());
		            dataA.add(so.getSupplierName());
		            dataA.add(so.getClientName());
		            dataA.add(so.getStorageName());
		            dataA.add(so.getNum());
		            dataA.add(so.getPrice());
		            dataA.add(so.getSum());
		            dataA.add(so.getAuditStatusName());
		            dataA.add(so.getCreatedtime());
		            dataA.add(so.getOutOfStoreTime());
		            objects.add(dataA);
		        }
		        try {
		        	OutputStream outputStream = response.getOutputStream();
		            Excel2003Utils.writeExcelData(outputStream, columnNames, sheetTitle, sheetName, objects);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
	    }
	
	@RequestMapping("/sales_orders_manage")
	public Object salesOrders() {
		return "sales_order";
	}
	@RequestMapping("/sales_orders_audit")
	public Object salesOrdersAudit() {
		return "sales_order_audit";
	}
	
	@ResponseBody
	@RequestMapping("/suppliers")
	public Object suppliers() {
		List<Supplier> suppliers = supplierService.getSuppliers(Integer.MAX_VALUE, 1L);
		return suppliers;
	}
	
	@ResponseBody
	@RequestMapping("/goodses")
	public Object goodses() {
		return goodsService.getGoodses(Integer.MAX_VALUE, 1L);
	}
	
	@ResponseBody
	@RequestMapping("/storages")
	public Object storages() {
		return storageService.getStoragesByName("", Integer.MAX_VALUE, 1L);
	}
	
	@ResponseBody
	@RequestMapping("/clients")
	public Object clients() {
		return clientService.getClients(Integer.MAX_VALUE, 1L, "");
	}
	
	@ResponseBody
	@RequestMapping("/goods_specications")
	public Object goodsSpecications() {
		return goodsService.getGoodsSpecifications();
	}
	
	@ResponseBody
	@RequestMapping("/sales_order_create")
	public Object createSalesOrder(SalesOrder salesOrder) {
		salesOrder.setName("");
		salesOrder.setCreatedtime(new Date());
		salesOrder.setAuditStatus("1");
		return paramToMap("isSucceed",salesOrderService.createSalesOrders(salesOrder) );
	}
	
	@ResponseBody
	@RequestMapping("/sales_order_modify")
	public Object modifySalesOrder(SalesOrder salesOrder) {
		salesOrder.setOutOfStoreTime(new Date());
		boolean salesOrderModifyFlag = salesOrderService.modifySalesOrder(salesOrder);
		boolean storageRecordFlag = false;
		if(salesOrderModifyFlag && ("已退货".equals(salesOrder.getAuditStatusName()) || "审核通过".equals(salesOrder.getAuditStatusName()))) {
			StorageRecord sr = new StorageRecord();
			sr.setGid(salesOrder.getSalesOrderGid());
			sr.setGspecificationId(salesOrder.getSalesOrderGspecificationId());
			sr.setStorageId(salesOrder.getStorageId());
			sr.setStorageCount(0);
			List<StorageRecord> storageRecord = storageService.getSimpleStorageRecord(sr);
			boolean hasRecord = storageRecord != null && storageRecord.size() > 0;
			System.err.println("审核通过，要修改库存");
			int salesCount = salesOrder.getNum();
			if("审核通过".equals(salesOrder.getAuditStatusName())) {
				salesCount = - salesOrder.getNum();
			}
			if(hasRecord) {
				System.err.println("有库存记录，直接修改即可");
				sr.setStorageCount(salesCount);
				storageRecordFlag = storageService.modifyStorageCount(sr);
				salesOrder.setOutOfStoreTime(new Date());
				salesOrderService.modifySalesOrder(salesOrder);
			} else {
				System.err.println("无库存记录，添加库存记录");
				sr.setStorageCount(salesCount);
			sr.setPreditedPrice(0);
			storageRecordFlag = storageService.createStorageRecord(sr);
			}
			return paramToMap("isSucceed",storageRecordFlag);
		}
		return paramToMap("isSucceed",salesOrderModifyFlag);
		
//		return paramToMap("isSucceed",salesOrderService.modifySalesOrder(salesOrder));
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public Object deleteGoodses(@RequestParam("gids[]") List<String> gids) {
		return paramToMap("isSucceed" , goodsService.deleteGoodses(gids));
	}
	
	@ResponseBody
	@RequestMapping("/sales_orders_modify")
	public Object modifySalesOrder(@RequestParam("soids[]") List<String> soids) {
		System.err.println(soids);
		return paramToMap("isSucceed",salesOrderService.modifySalesOrder(soids));
	}
}
