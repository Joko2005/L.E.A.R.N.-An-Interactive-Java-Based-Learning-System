package datavisualization.data;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.general.DefaultValueDataset;

public class SampleData {

    public static DefaultCategoryDataset getInventoryDataset() {
        DefaultCategoryDataset d = new DefaultCategoryDataset();
        d.addValue(65, "Inventory", "Toyota");
        d.addValue(80, "Inventory", "Ford");
        d.addValue(45, "Inventory", "Volkswagen");
        d.addValue(55, "Inventory", "BMW");
        d.addValue(53, "Inventory", "Honda");
        d.addValue(47, "Inventory", "Tesla");
        return d;
    }

    public static DefaultPieDataset getSalesPieDataset() {
        DefaultPieDataset p = new DefaultPieDataset();
        p.setValue("Toyota", 318.53);
        p.setValue("Ford", 782.94);
        p.setValue("Volkswagen", 441.29);
        p.setValue("BMW", 561.47);
        p.setValue("Honda", 531.59);
        p.setValue("Tesla", 451.24);
        return p;
    }

    public static XYSeriesCollection getMonthlyTrendDataset() {
        XYSeries sales = new XYSeries("Sales");
        XYSeries revenue = new XYSeries("Revenue");
        XYSeries expenses = new XYSeries("Expenses");
        int[] s = {50, 80, 45, 90, 70, 60, 20, 55, 95, 88, 76, 65};
        int[] r = {45, 95, 100, 90, 98, 88, 25, 60, 110, 100, 95, 70};
        int[] e = {70, 60, 40, 60, 50, 45, 30, 20, 70, 78, 55, 50};
        for (int m = 1; m <= 12; m++) {
            sales.add(m, s[m - 1]);
            revenue.add(m, r[m - 1]);
            expenses.add(m, e[m - 1]);
        }
        XYSeriesCollection col = new XYSeriesCollection();
        col.addSeries(sales);
        col.addSeries(revenue);
        col.addSeries(expenses);
        return col;
    }

    public static DefaultCategoryDataset getRevenueAreaDataset() {
        DefaultCategoryDataset d = new DefaultCategoryDataset();
        d.addValue(50, "Revenue", "Jan");
        d.addValue(70, "Revenue", "Feb");
        d.addValue(95, "Revenue", "Mar");
        d.addValue(90, "Revenue", "Apr");
        d.addValue(100, "Revenue", "May");
        d.addValue(85, "Revenue", "Jun");
        d.addValue(40, "Revenue", "Jul");
        d.addValue(60, "Revenue", "Aug");
        d.addValue(95, "Revenue", "Sep");
        d.addValue(105, "Revenue", "Oct");
        d.addValue(98, "Revenue", "Nov");
        d.addValue(78, "Revenue", "Dec");
        return d;
    }

    public static DefaultCategoryDataset getStackedSalesDataset() {
        DefaultCategoryDataset d = new DefaultCategoryDataset();
        d.addValue(120, "Toyota", "Q1");
        d.addValue(150, "Ford", "Q1");
        d.addValue(90, "Volkswagen", "Q1");
        d.addValue(110, "BMW", "Q1");

        d.addValue(140, "Toyota", "Q2");
        d.addValue(170, "Ford", "Q2");
        d.addValue(95, "Volkswagen", "Q2");
        d.addValue(120, "BMW", "Q2");

        d.addValue(160, "Toyota", "Q3");
        d.addValue(190, "Ford", "Q3");
        d.addValue(110, "Volkswagen", "Q3");
        d.addValue(130, "BMW", "Q3");

        d.addValue(180, "Toyota", "Q4");
        d.addValue(200, "Ford", "Q4");
        d.addValue(120, "Volkswagen", "Q4");
        d.addValue(140, "BMW", "Q4");
        return d;
    }

    public static DefaultValueDataset getStockUtilizationDataset() {
        return new DefaultValueDataset(76);
    }
}