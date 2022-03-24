public class Product implements IProduct{
    @Override
    public void installFirstPart(IProductPart productPart) {
        System.out.println("Installing the first part");
    }

    @Override
    public void installSecondPart(IProductPart productPart) {
        System.out.println("Installing the second part");
    }

    @Override
    public void installThirdPart(IProductPart productPart) {
        System.out.println("Installing the third part");
    }
}
