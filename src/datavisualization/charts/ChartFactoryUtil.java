package datavisualization.charts;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.Range;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.plot.MeterInterval;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;

public class ChartFactoryUtil {

    private static final Color TRANSPARENT = new Color(0, 0, 0, 0);
    private static final Color GRID_COLOR  = new Color(90, 96, 140);
    private static final Color LABEL_COLOR = new Color(166, 176, 200);
    private static final Color LEGEND_TEXT = new Color(220, 226, 246);

    private static final Font  LABEL_FONT  = new Font("Montserrat", Font.PLAIN, 12);
    private static final Font  LEGEND_FONT = new Font("Montserrat", Font.PLAIN, 12);

    private static final Color[] BRAND_COLORS = {
        new Color(88, 187, 221),  // Toyota
        new Color(240, 197, 88),  // Ford
        new Color(95, 169, 128),  // Volkswagen
        new Color(229, 150, 98),  // BMW
        new Color(223, 124, 155), // Honda
        new Color(180, 150, 235)  // Tesla
    };

    // Inventory bar chart
    public static JFreeChart createInventoryBarChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                null, null, null, dataset,
                PlotOrientation.VERTICAL, false, false, false);

        chart.setBackgroundPaint(TRANSPARENT);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(TRANSPARENT);
        plot.setOutlineVisible(false);

        // Gridlines
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinesVisible(true);
        plot.setDomainGridlinePaint(GRID_COLOR);
        plot.setRangeGridlinePaint(GRID_COLOR);
        Stroke dashed = new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0f, new float[]{2f, 4f}, 0f);
        plot.setDomainGridlineStroke(dashed);
        plot.setRangeGridlineStroke(dashed);

        // Axis styling
        CategoryAxis domain = plot.getDomainAxis();
        domain.setTickLabelFont(LABEL_FONT);
        domain.setLabelFont(LABEL_FONT);
        domain.setTickLabelPaint(LABEL_COLOR);
        domain.setLabelPaint(LABEL_COLOR);
        domain.setCategoryMargin(0.18);
        domain.setLowerMargin(0.02);
        domain.setUpperMargin(0.02);

        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setTickLabelFont(LABEL_FONT);
        range.setLabelFont(LABEL_FONT);
        range.setTickLabelPaint(LABEL_COLOR);
        range.setLabelPaint(LABEL_COLOR);
        range.setAutoRangeIncludesZero(true);
        range.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        range.setLowerMargin(0.05);
        range.setUpperMargin(0.05);

        // Renderer
        CategoryColorRenderer renderer = new CategoryColorRenderer(dataset, BRAND_COLORS);
        renderer.setShadowVisible(false);
        renderer.setBarPainter(new StandardBarPainter());
        renderer.setDrawBarOutline(false);
        renderer.setItemMargin(0.02);
        plot.setRenderer(renderer);

        LegendItemCollection items = new LegendItemCollection();
        for (int c = 0; c < dataset.getColumnCount(); c++) {
            Comparable<?> key = dataset.getColumnKey(c);
            Color color = BRAND_COLORS[c % BRAND_COLORS.length];
            LegendItem li = new LegendItem(
                    key.toString(),
                    null, null, null,
                    new Rectangle2D.Double(10, 10, 10, 10),
                    color);
            items.add(li);
        }
        LegendItemSource source = () -> items;
        LegendTitle brandLegend = new LegendTitle(source);
        brandLegend.setBackgroundPaint(TRANSPARENT);
        brandLegend.setFrame(BlockBorder.NONE);
        brandLegend.setItemFont(LEGEND_FONT);
        brandLegend.setItemPaint(LEGEND_TEXT);
        brandLegend.setPosition(RectangleEdge.BOTTOM);
        chart.addSubtitle(brandLegend);

        return chart;
    }

public static JFreeChart createSalesPieChart(DefaultPieDataset dataset) {
    JFreeChart chart = ChartFactory.createPieChart(null, dataset, true, true, false);
    chart.setBackgroundPaint(TRANSPARENT);

    PiePlot plot = (PiePlot) chart.getPlot();
    plot.setBackgroundPaint(TRANSPARENT);
    plot.setOutlineVisible(false);
    plot.setShadowPaint(null);
    plot.setCircular(true);
    plot.setStartAngle(90);
    plot.setInteriorGap(0.02);
    plot.setSimpleLabels(true);                             // labels inside slices
    plot.setSimpleLabelOffset(new org.jfree.chart.ui.RectangleInsets(24, 38, 24, 38)); // move labels inward
    plot.setLabelGap(0.02);
    plot.setLabelPadding(new org.jfree.chart.ui.RectangleInsets(0, 3, 0, 3));  // compact label box
    plot.setMinimumArcAngleToDraw(3.0);

    plot.setLabelGenerator(new org.jfree.chart.labels.StandardPieSectionLabelGenerator(
        "{0} {2}",
        new java.text.DecimalFormat("#,##0"),
        new java.text.DecimalFormat("0.0%")
    ));
    plot.setLabelFont(new java.awt.Font("Montserrat", java.awt.Font.PLAIN, 12));
    plot.setLabelPaint(java.awt.Color.WHITE);
    plot.setLabelBackgroundPaint(new java.awt.Color(0,0,0,0));
    plot.setLabelOutlinePaint(new java.awt.Color(0,0,0,0));
    plot.setLabelShadowPaint(null);

    // Apply palette
    for (int i = 0; i < dataset.getItemCount(); i++) {
        Comparable<?> key = dataset.getKey(i);
        plot.setSectionPaint(key, BRAND_COLORS[i % BRAND_COLORS.length]);
    }

    // Legend on the left
    org.jfree.chart.title.LegendTitle legend = chart.getLegend();
    if (legend != null) {
        legend.setBackgroundPaint(TRANSPARENT);
        legend.setFrame(org.jfree.chart.block.BlockBorder.NONE);
        legend.setItemFont(new java.awt.Font("Montserrat", java.awt.Font.PLAIN, 16));
        legend.setItemPaint(LEGEND_TEXT);
        legend.setItemLabelPadding(new RectangleInsets(4, 10, 4, 10)); // space around each label
        legend.setPadding(new RectangleInsets(10, 12, 10, 12));        // padding around the whole legend box
        legend.setPosition(org.jfree.chart.ui.RectangleEdge.LEFT);
    }
    return chart;
}

    public static JFreeChart createMonthlyLineChart(XYSeriesCollection dataset) {
    JFreeChart chart = ChartFactory.createXYLineChart(null, null, null, dataset,
            PlotOrientation.VERTICAL, true, true, false);
    chart.setBackgroundPaint(TRANSPARENT);

    XYPlot plot = chart.getXYPlot();
    plot.setBackgroundPaint(TRANSPARENT);
    plot.setOutlineVisible(false);
    plot.setDomainGridlinePaint(GRID_COLOR);
    plot.setRangeGridlinePaint(GRID_COLOR);
    Stroke dashed = new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0f, new float[]{2f, 4f}, 0f);
    plot.setDomainGridlineStroke(dashed);
    plot.setRangeGridlineStroke(dashed);


    NumberAxis y = (NumberAxis) plot.getRangeAxis();
    y.setTickLabelPaint(LABEL_COLOR);
    y.setTickLabelFont(LABEL_FONT);
    org.jfree.chart.axis.ValueAxis x = plot.getDomainAxis();
    x.setTickLabelPaint(LABEL_COLOR);
    x.setTickLabelFont(LABEL_FONT);

    // Lines and circular markers
    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, true);
    Color[] lineColors = {
        new Color(236, 92, 92),
        new Color(140, 168, 255),
        new Color(105, 211, 255)
    };
    for (int s = 0; s < dataset.getSeriesCount(); s++) {
        renderer.setSeriesStroke(s, new BasicStroke(2.6f));
        renderer.setSeriesPaint(s, lineColors[s % lineColors.length]);
        renderer.setSeriesShapesVisible(s, true);
        renderer.setSeriesShape(s, new Ellipse2D.Double(-3, -3, 6, 6));
    }
    plot.setRenderer(renderer);

    LegendTitle legend = chart.getLegend();
    if (legend != null) {
        legend.setBackgroundPaint(TRANSPARENT);
        legend.setFrame(BlockBorder.NONE);
        legend.setItemFont(LEGEND_FONT);
        legend.setItemPaint(LEGEND_TEXT);
        legend.setPosition(RectangleEdge.BOTTOM);
    }
    return chart;
}

    public static JFreeChart createStackedBarChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createStackedBarChart(null, null, null, dataset,
                PlotOrientation.VERTICAL, true, true, false);
        styleCategoryChartTransparent(chart);
        return chart;
    }

    public static JFreeChart createMeterChart(DefaultValueDataset dataset) {
        MeterPlot meterPlot = new MeterPlot(dataset);
        meterPlot.setRange(new Range(0.0, 100.0));
        Stroke stroke = new BasicStroke(1.2f);
        meterPlot.addInterval(new MeterInterval("Low",  new Range(0, 50),  new Color(46, 204, 113), stroke, new Color(46,204,113)));
        meterPlot.addInterval(new MeterInterval("Med",  new Range(50, 80), new Color(241, 196, 15), stroke, new Color(241,196,15)));
        meterPlot.addInterval(new MeterInterval("High", new Range(80, 100), new Color(231, 76, 60),  stroke, new Color(231,76,60)));
        meterPlot.setDialBackgroundPaint(TRANSPARENT);

        JFreeChart chart = new JFreeChart(null, new Font("Montserrat", Font.BOLD, 14), meterPlot, false);
        chart.setBackgroundPaint(TRANSPARENT);
        return chart;
    }

    private static void styleCategoryChartTransparent(JFreeChart chart) {
        chart.setBackgroundPaint(TRANSPARENT);
        Plot p = chart.getPlot();
        p.setBackgroundPaint(TRANSPARENT);
        p.setOutlineVisible(false);
        if (p instanceof CategoryPlot cp) {
            cp.setDomainGridlinesVisible(true);
            cp.setRangeGridlinesVisible(true);
            cp.setDomainGridlinePaint(GRID_COLOR);
            cp.setRangeGridlinePaint(GRID_COLOR);
        }
        LegendTitle legend = chart.getLegend();
        if (legend != null) {
            legend.setBackgroundPaint(TRANSPARENT);
            legend.setFrame(BlockBorder.NONE);
            legend.setItemFont(LEGEND_FONT);
            legend.setItemPaint(LEGEND_TEXT);
        }
    }

    public static ChartPanel createChartPanel(JFreeChart chart, int w, int h) {
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(w, h));
        panel.setOpaque(false);
        panel.setBackground(TRANSPARENT);
        panel.setBorder(null);
        panel.setMouseWheelEnabled(false);
        return panel;
    }

    // Renderer that colors bars per category
    private static class CategoryColorRenderer extends BarRenderer {
        private final Color[] colors;
        CategoryColorRenderer(DefaultCategoryDataset dataset, Color[] colors) {
            this.colors  = colors;
        }
        @Override
        public Paint getItemPaint(int row, int column) {
            return colors[column % colors.length];
        }
    }
}