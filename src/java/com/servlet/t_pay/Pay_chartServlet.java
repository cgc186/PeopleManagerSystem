/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.t_pay;

import com.dao.T_payDao;
import com.pojo.T_deptPay;
import com.service.PayService;
import java.awt.Font;
import java.io.IOException;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建商品分类的柱状图
 *
 * @author pibigstar
 *
 */
@SuppressWarnings("serial")
@WebServlet("/Pay_chartServlet")
public class Pay_chartServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("image/jpeg");
        response.setCharacterEncoding("utf-8");
        String dno = request.getParameter("dno");
        CategoryDataset dataset;
        if ("all".equals(dno)) {
            dataset = getDataSet();
        } else {
            int i = Integer.parseInt(dno);
            dataset = getDataSetByid(i);
        }

        //创建主题样式  
        StandardChartTheme mChartTheme = new StandardChartTheme("CN");
        //设置标题字体  
        mChartTheme.setExtraLargeFont(new Font("黑体", Font.BOLD, 20));
        //设置轴向字体  
        mChartTheme.setLargeFont(new Font("宋体", Font.CENTER_BASELINE, 15));
        //设置图例字体  
        mChartTheme.setRegularFont(new Font("宋体", Font.CENTER_BASELINE, 15));
        //应用主题样式  
        ChartFactory.setChartTheme(mChartTheme);
        JFreeChart chart = ChartFactory.createBarChart3D(
                "部门成本", // 图表标题
                "金额", // 目录轴的显示标签
                "部门", // 数值轴的显示标签
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                true, // 是否显示图例(对于简单的柱状图必须是 false)
                false, // 是否生成工具
                false // 是否生成 URL 链接
        );

        ChartUtilities.writeChartAsJPEG(response.getOutputStream(),
                1.0f, chart, 1200, 500, null);
    }

    /**
     * 获取一个数据集对象
     *
     * @return
     * @throws IOException
     */
    private static CategoryDataset getDataSet() throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        PayService ps = new PayService();
        List<T_deptPay> Deptcost = ps.selectDeptcost();
        for (T_deptPay deptPay : Deptcost) {
            System.out.println(Deptcost);
            dataset.addValue(deptPay.getBudget(), "预算", "部门" + deptPay.getDno());
            dataset.addValue(deptPay.getActualBudget(), "实际花费", "部门" + deptPay.getDno());
        }
        return dataset;
    }

    private static CategoryDataset getDataSetByid(int dno) throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        PayService ps = new PayService();
        List<T_deptPay> Deptcost = ps.selectDeptcostByid(dno);
        for (T_deptPay deptPay : Deptcost) {
            System.out.println(Deptcost);
            dataset.addValue(deptPay.getBudget(), "预算", "部门" + deptPay.getDno());
            dataset.addValue(deptPay.getActualBudget(), "实际花费", "部门" + deptPay.getDno());
        }
        return dataset;
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
