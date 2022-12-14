package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.model.Representative;

public class GenerateRepresentative {

    public static Representative newRepresentative(){
        return Representative.builder()
                .id(2)
                .name("Pedro")
                .wareHouse(null)
                .build();
    }

    public static Representative getRepresentativeById(){
        return Representative.builder()
                .id(2)
                .name("Pedro")
                .wareHouse(GenerateWareHouse.newWareHouse())
                .build();
    }
}
