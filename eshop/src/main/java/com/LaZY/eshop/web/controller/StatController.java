package com.LaZY.eshop.web.controller;

import com.LaZY.eshop.model.Stat;
import com.LaZY.eshop.service.StatService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
/**
 * @author LaZY(李志一)
 * @create 2019-03-15 17:41
 */
@Controller
public class StatController {
    @Resource(name="StatService")
    private StatService ss ;


    @RequestMapping(value = "/admin/toStatPage")
    public String toStatPage(){
        return "statList" ;
    }
    @RequestMapping("/admin/statYesterday")
    public String yesStat(HttpServletResponse resp) throws IOException {
        List<Stat> list = ss.findAllEntities();

        //数据集
        DefaultPieDataset ds = new DefaultPieDataset();
        for(Stat s : list){
            ds.setValue(s.getDesc(),s.getCount());
        }

        JFreeChart chart = ChartFactory.createPieChart("昨天网站PV", ds, false, false, false);

        Font font = new Font("宋体", Font.BOLD, 15);
        chart.getTitle().setFont(font);
        //背景透明

        ((PiePlot) chart.getPlot()).setForegroundAlpha(0.2f);
        ((PiePlot) chart.getPlot()).setExplodePercent("Apple", 0.1f);
        ((PiePlot) chart.getPlot()).setExplodePercent("HuaWei", 0.2f);
        ((PiePlot) chart.getPlot()).setExplodePercent("Mi", 0.3f);


        //创建3D饼图
        OutputStream out = resp.getOutputStream();
        //将图片输出给浏览器了
        ChartUtilities.writeChartAsJPEG(out,chart,600,400);
        return null ;
    }
}
