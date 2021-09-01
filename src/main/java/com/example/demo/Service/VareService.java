package com.example.demo.Service;

import com.example.demo.Model.Vare;
import com.example.demo.Repository.VareRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VareService {


    @Autowired
    VareRepo vareRepo;

    public List<Vare> showAllVare(){
        return vareRepo.showAllVare();
    }
    public Vare findVareById(int id){

        return vareRepo.findVareById(id);
    }
    public Vare createVare(Vare v){
        vareRepo.createVare(v);
        return null;
    }
    public Vare updateVare(Vare v){
        vareRepo.updateVare(v);
        return null;
    }
    public boolean deleteVare(int id){
        return vareRepo.deleteVare(id);
    }

}
