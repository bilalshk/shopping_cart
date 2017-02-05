package com.shopping.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import com.shopping.service.OrderDetailService;
import com.shopping.service.OrderDetailServiceImplement;
import com.shopping.service.OrderService;
import com.shopping.service.OrderServiceImplement;
import com.shopping.service.ProductService;
import com.shopping.service.ProductServiceImplement;
import com.shopping.service.UserService;
import com.shopping.service.UserServiceImplement;

/**
 * Created by bilalshaikh on 2/2/17.
 */
public class ShoppingClient {

    static UserService userService;
    static ProductService productService;
    static OrderService orderService;
    static OrderDetailService orderDetailService;
    static {
        userService = new UserServiceImplement();
        productService = new ProductServiceImplement();
        orderService = new OrderServiceImplement();
        orderDetailService = new OrderDetailServiceImplement();
    }

    public static void main(String[] args) throws IOException, SQLException, ParseException {

        int duid, uid, did;
        String un, fn, ln, add;

        int dpid, upid, ps, did1;
        String pn, pc;
        Double pp;

        int oid, oid1, ouid, oidd;
        String odate;
        Double oamt;

        int odid, odidu, odo, odp, odq, odd;
        Double odpr, oda;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //CRUD Logic for Order Dao and Services
        ShoppingClient scu = new ShoppingClient();
        File user = new File("/Users/bilalshaikh/Java/ShoppingCart/src/User");
        scu.userService.usercreate(user);

        System.out.print("Enter the user id to delete: ");
        duid = Integer.parseInt(br.readLine());
        scu.userService.userdelete(duid);

        System.out.print("Enter the user id to update data: ");
        uid = Integer.parseInt(br.readLine());
        System.out.println();

        System.out.print("Enter the user name: ");
        un = br.readLine();
        System.out.println();

        System.out.print("Enter the first name: ");
        fn = br.readLine();
        System.out.println();

        System.out.print("Enter the last name: ");
        ln = br.readLine();
        System.out.println();

        System.out.print("Enter the address: ");
        add = br.readLine();
        System.out.println();
        scu.userService.userupdate(uid, un, fn, ln, add);

        scu.userService.userdisplay();

        System.out.println();
        System.out.print("Enter the userid to display details: ");
        did = Integer.parseInt(br.readLine());
        scu.userService.useriddisplay(did);

        //CRUD Logic for Product Dao and Services
        ShoppingClient scp = new ShoppingClient();
        File prod = new File("/Users/bilalshaikh/Java/ShoppingCart/src/Product");
        scp.productService.productcreate(prod);

        System.out.print("Enter the product id to delete: ");
        dpid = Integer.parseInt(br.readLine());
        scp.productService.productdelete(dpid);

        System.out.print("Enter the product id to update data: ");
        upid = Integer.parseInt(br.readLine());
        System.out.println();

        System.out.print("Enter the product name: ");
        pn = br.readLine();
        System.out.println();

        System.out.print("Enter the product code: ");
        pc = br.readLine();
        System.out.println();

        System.out.print("Enter the product price: ");
        pp = Double.parseDouble(br.readLine());
        System.out.println();

        System.out.print("Enter the product stock: ");
        ps = Integer.parseInt(br.readLine());
        scp.productService.productupdate(upid, pn, pc, pp, ps);

        scp.productService.productdisplay();

        System.out.println();
        System.out.print("Enter the product to display details: ");
        did1 = Integer.parseInt(br.readLine());
        scp.productService.productiddisplay(did1);

        //CRUD Logic for Order Dao and Services

        ShoppingClient sco = new ShoppingClient();
        File ord = new File("/Users/bilalshaikh/Java/ShoppingCart/src/Order");
        sco.orderService.ordercreate(ord);

        System.out.print("Enter the order id to delete: ");
        oid = Integer.parseInt(br.readLine());
        sco.orderService.orderdelete(oid);

        System.out.print("Enter the order id to update data: ");
        oid1 = Integer.parseInt(br.readLine());
        System.out.println();

        System.out.print("Enter the order date in (yyyy-mm-dd): ");
        odate = br.readLine();
        System.out.println();

        System.out.print("Enter the order amount: ");
        oamt = Double.parseDouble(br.readLine());
        System.out.println();

        System.out.print("Enter the user id: ");
        ouid = Integer.parseInt(br.readLine());
        System.out.println();

        sco.orderService.orderupdate(oid1, odate, oamt,ouid);

        sco.orderService.orderdisplay();

        System.out.println();
        System.out.print("Enter the orderid to display details: ");
        oidd = Integer.parseInt(br.readLine());
        sco.orderService.orderbyid(oidd);

        //CRUD logic for ORderDetails

        ShoppingClient scod = new ShoppingClient();
        File ordd = new File("/Users/bilalshaikh/Java/ShoppingCart/src/OrderDetails");
        scod.orderDetailService.orderdetailcreate(ordd);

        System.out.print("Enter the order details id to delete: ");
        odid = Integer.parseInt(br.readLine());
        scod.orderDetailService.orderdetaildelete(odid);

        System.out.print("Enter the order details id to update data: ");
        odidu = Integer.parseInt(br.readLine());
        System.out.println();

        System.out.print("Enter the order id of order details: ");
        odo = Integer.parseInt(br.readLine());
        System.out.println();

        System.out.print("Enter the product id of order dedails: ");
        odp = Integer.parseInt(br.readLine());
        System.out.println();

        System.out.print("Enter the quantity: ");
        odq = Integer.parseInt(br.readLine());
        System.out.println();

        System.out.print("Enter the price: ");
        odpr = Double.parseDouble(br.readLine());
        System.out.println();

        System.out.print("Enter the amount: ");
        oda = Double.parseDouble(br.readLine());
        System.out.println();

        scod.orderDetailService.orderdetailupdate(odidu, odo, odp, odq, odpr, oda);

        scod.orderDetailService.orderddetaildisplay();

        System.out.println();
        System.out.print("Enter the orderid to display details: ");
        odd = Integer.parseInt(br.readLine());
        scod.orderDetailService.orderdetailbyid(odd);



    }
}
