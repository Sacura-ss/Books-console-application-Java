public class AssemblyLine implements IAssemblyLine{

    private LineStep firstStep;
    private LineStep secondStep;
    private LineStep thirdStep;


    public AssemblyLine(LineStep firstStep, LineStep secondStep, LineStep thirdStep) {
        this.firstStep = firstStep;
        this.secondStep = secondStep;
        this.thirdStep = thirdStep;
    }

    @Override
    public IProduct assembleProduct(IProduct product) {
        System.out.println("Beginning of work.....");

        IProductPart firstPart =  firstStep.buildProductPart();
        IProductPart secondPart = secondStep.buildProductPart();
        IProductPart thirdPart = thirdStep.buildProductPart();
        System.out.println("Received thee parts of the products " + product.getClass());

        product.installFirstPart(firstPart);
        product.installSecondPart(secondPart);
        product.installThirdPart(thirdPart);
        System.out.println("Established thee parts of the products " + product.getClass());

        System.out.println("Get the finished product");
        return product;
    }
}
