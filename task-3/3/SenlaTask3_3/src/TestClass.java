public class TestClass {
    public static void main(String[] args) {
        Product blank = new Product(); //заготовка продукта
        AssemblyLine assemblyLine = new AssemblyLine(new LineStep(), new LineStep(), new LineStep());
        assemblyLine.assembleProduct(blank);
    }
}
