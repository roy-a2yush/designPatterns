package org.example.designpattern.creational;

public class BuilderPatternExample {
}

class Smartphone {
    int price;
    int ram;
    String os;
    int internalStorage;

    @Override
    public String toString() {
        return "Smartphone{" +
            "price=" + price +
            ", ram=" + ram +
            ", os='" + os + '\'' +
            ", internalStorage=" + internalStorage +
            ", cameraMegaPixel=" + cameraMegaPixel +
            '}';
    }

    int cameraMegaPixel;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getInternalStorage() {
        return internalStorage;
    }

    public void setInternalStorage(int internalStorage) {
        this.internalStorage = internalStorage;
    }

    public int getCameraMegaPixel() {
        return cameraMegaPixel;
    }

    public void setCameraMegaPixel(int cameraMegaPixel) {
        this.cameraMegaPixel = cameraMegaPixel;
    }
}


class SmartphoneBuilder {

    Smartphone smartphone;
    SmartphoneBuilder() {
        this.smartphone = new Smartphone();
    }
    public SmartphoneBuilder setPrice(int price) {
        smartphone.setPrice(price);
        return this;
    }

    public SmartphoneBuilder setRam(int ram) {
        smartphone.setRam(ram);
        return this;
    }

    public SmartphoneBuilder setOs(String os) {
        smartphone.setOs(os);
        return this;
    }

    public SmartphoneBuilder setInternalStorage(int internalStorage) {
        smartphone.setInternalStorage(internalStorage);
        return this;
    }

    public SmartphoneBuilder setCameraMegaPixel(int cameraMegaPixel) {
        smartphone.setCameraMegaPixel(cameraMegaPixel);
        return this;
    }

    public Smartphone build() {
        return smartphone;
    }
}

class SmartphoneChoice {
    public static void main(String[] args) {
        SmartphoneBuilder smartphoneBuilder = new SmartphoneBuilder();
        Smartphone smartphone = smartphoneBuilder.setPrice(100)
            .setRam(4)
            .setCameraMegaPixel(12)
            .build();
        System.out.println(smartphone);
    }
}