package com.example.travel;

import com.example.travel.entity.travel;
import com.example.travel.repository.travelrepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class travelrepositoryTests {

    @Autowired
    private travelrepository travelrepository;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveItem(){
        travel travel= new travel();

        travel.setDescription("Testing description");
        travel.setDestinationname("Testing item name");
        travel.setCategory("HimalayanTreks");
        travel.setSection("section1");




        travel=travelrepository.save(travel);

        Assertions.assertThat(travel.getId()).isGreaterThan(0);


    }


    @Test
    @Order(2)
    public void findById(){
        travel item= travelrepository.findById(1).get();
        Assertions.assertThat(item.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void findAllData(){
        List<travel> itemList=travelrepository.findAll();
        Assertions.assertThat(itemList.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updateItem(){
        travel item= travelrepository.findById(1).get();
        item.setDestinationname("updated testing item name");
        item=travelrepository.save(item);

        Assertions.assertThat(item.getDestinationname()).isEqualTo("updated testing item name");
    }

    @Test
    @Order(5)
    public void DeleteByID(){
        travelrepository.deleteById(1);

        travel item1=null;

        Optional<travel> item=travelrepository.findById(1);

        if(item.isPresent()){
            item1=item.get();
        }

        Assertions.assertThat(item1).isNull();

    }
}