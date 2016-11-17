package com.infoedge.jrandomizer.providers;

/**
 * Created by ronakporiya on 21/10/16.
 */
public class CarBrandProvider extends Provider<String[]> {
    private CarBrandProvider(Class<String[]> clazz) {
        super(clazz);
    }

    @Override
    public String[] provide() {
        if (mLoadedData == null) {
            mLoadedData = new String[]{
                    "Acura",
                    "Alfa Romeo",
                    "Aston Martin",
                    "Audi",
                    "Bentley",
                    "BMW",
                    "Bugatti",
                    "Buick",
                    "Cadillac",
                    "Chevrolet",
                    "Chrysler",
                    "Citroen",
                    "Dodge",
                    "Ferrari",
                    "Fiat",
                    "Ford",
                    "Geely",
                    "General Motors",
                    "GMC",
                    "Honda",
                    "Hyundai",
                    "Infiniti",
                    "Jaguar",
                    "Jeep",
                    "Kia",
                    "Kia Motors",
                    "Koenigsegg",
                    "Lamborghini",
                    "Land Rover",
                    "Lexus",
                    "Maserati",
                    "Mazda",
                    "McLaren",
                    "Mercedes Benz",
                    "Mercedes-Benz",
                    "Mini",
                    "Mitsubishi",
                    "Mitsubishi Motors",
                    "Nissan",
                    "Pagani",
                    "Peugeot",
                    "Porsche",
                    "Ram",
                    "Renault",
                    "Rolls Royce",
                    "Saab",
                    "Subaru",
                    "Suzuki",
                    "TATA Motors",
                    "Tesla",
                    "Tesla Motors",
                    "Toyota",
                    "Volkswagen",
                    "Volvo"
            };
        }
        return mLoadedData;
    }

}
