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
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpss.common.utils.BeanUtils;
import com.gpss.common.utils.Excel2003Utils;
import com.lyyzoo.gpss.api.service.IGoodsService;
import com.lyyzoo.gpss.api.service.IOrderStatusService;
import com.lyyzoo.gpss.api.service.IPurchaseOrderService;
import com.lyyzoo.gpss.api.service.IStorageService;
import com.lyyzoo.gpss.api.service.ISupplierService;
import com.lyyzoo.gpss.api.vo.OrderStatus;
import com.lyyzoo.gpss.api.vo.PurchaseOrder;
import com.lyyzoo.gpss.api.vo.Supplier;

@RequestMapping("/purchase")
@Controller
public class PurchaseController extends AbstractController{

	@Resource
	private IPurchaseOrderService purchaseOrderService;
	@Resource
	private ISupplierService supplierService;
	@Resource
	private IStorageService storageService;
	@Resource
	private IGoodsService goodsService;
	@Resource
	private IOrderStatusService orderStatusService;
	
	@ResponseBody
	@RequestMapping(value ="/purchase_orders", method = RequestMethod.GET)
	public Object getPurchaseOrders(int pageSize , Long currentPage, PurchaseOrder purchaseOrder) {
		System.err.println(purchaseOrder.getAuditStatus() == null);
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> params = BeanUtils.beanToMap(purchaseOrder);
		map.put("total", purchaseOrderService.getPurchaseOrdersCount(params));
		List<PurchaseOrder> list = purchaseOrderService.getPurchaseOrders(params, pageSize, currentPage);
		map.put("rows", list);
		return map;
	}
	
	   @RequestMapping(value = "/purchase_orders/output_data", method = RequestMethod.GET)
	    public void downLoadExcel(int pageSize , Long currentPage, PurchaseOrder purchaseOrder,HttpServletRequest request, HttpServletResponse response) throws IOException{
		   String sheetName = "采购订单数据";
	        String sheetTitle = "采购订单数据";
	        String fileName = "采购订单报表.xls";
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
	        columnNames.add("仓库");
	        columnNames.add("数量");
	        columnNames.add("单价");
	        columnNames.add("总价");
	        columnNames.add("审核状态");
	        columnNames.add("创建时间");
			Map<String,Object> map = new HashMap<String,Object>();
			Map<String,Object> params = BeanUtils.beanToMap(purchaseOrder);
			List<PurchaseOrder> list = purchaseOrderService.getPurchaseOrders(params, pageSize, currentPage);
			map.put("rows", list);
		        List<List<Object>> objects = new LinkedList<>();
		        for (int i = 0; i < list.size(); i++) {
		            List<Object> dataA = new LinkedList<>();
		            PurchaseOrder po = list.get(i);
		            dataA.add(po.getPoid());
		            dataA.add(po.getGname());
		            dataA.add(po.getGsname());
		            dataA.add(po.getSupplierName());
		            dataA.add(po.getStorageName());
		            dataA.add(po.getNum());
		            dataA.add(po.getPrice());
		            dataA.add(po.getSum());
		            dataA.add(po.getAuditStatus());
		            dataA.add(po.getCreatedtime());
		            objects.add(dataA);
		        }
		        try {
		        	OutputStream outputStream = response.getOutputStream();
		            Excel2003Utils.writeExcelData(outputStream, columnNames, sheetTitle, sheetName, objects);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
	    }
	
	@RequestMapping("/purchase_orders_manage")
	public Object purchaseOrders() {
		return "purchase_order";
	}
	
	@RequestMapping("/purchase_orders_audit")
	public Object purchaseOrdersAudit() {
		return "purchase_order_audit";
	}
	
	@ResponseBody
	@RequestMapping("/order_status")
	public Object orderStatus() {
		List<OrderStatus> orderStatuses = orderStatusService.getOrderStatus();
		return orderStatuses;
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
	@RequestMapping("/goods_specications")
	public Object goodsSpecications() {
		return goodsService.getGoodsSpecifications();
	}
	
	@ResponseBody
	@RequestMapping("/purchase_order_create")
	public Object createPurchaseOrder(PurchaseOrder purchaseOrder) {
		purchaseOrder.setName("");
		purchaseOrder.setCreatedtime(new Date());
		purchaseOrder.setAuditStatus("1");
		return paramToMap("isSucceed",purchaseOrderService.createPurchaseOrders(purchaseOrder) );
	}
	
	@ResponseBody
	@RequestMapping("/purchase_order_modify")
	public Object modifyPurchaseOrder(PurchaseOrder purchaseOrder) {
		return paramToMap("isSucceed",purchaseOrderService.modifyPurchaseOrder(purchaseOrder));
	}
}
