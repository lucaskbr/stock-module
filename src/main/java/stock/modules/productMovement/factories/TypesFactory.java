package stock.modules.productMovement.factories;

import stock.modules.productMovement.ProductMovement;

public class TypesFactory {

    public static ProductMovement.Type getType (String type) throws Exception {
        switch (type){
            case "PICKUP_RESERVATION":
                return ProductMovement.Type.PICKUP_RESERVATION;
            case "BUY":
                return ProductMovement.Type.BUY;
            case "ADJUSTMENT":
                return ProductMovement.Type.ADJUSTMENT;
            case "DEVOLUTION":
                return ProductMovement.Type.DEVOLUTION;
            case "LOSS":
                return ProductMovement.Type.LOSS;
            case "INTERN_CONSUMPTION":
                return ProductMovement.Type.INTERN_CONSUMPTION;
            case "MANUFACTURE":
                return ProductMovement.Type.MANUFACTURE;
            case "SELL":
                return ProductMovement.Type.SELL;
            default:
                throw new Exception("Enum not defined");
        }
    }

}