public class LineStep implements ILineStep{

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Creating a part of the product");
        return null;
    }
}
