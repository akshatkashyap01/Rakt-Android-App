package com.example.rakt.DonorInformation;

import java.io.Serializable;
import java.util.ArrayList;

public class DonorRoot implements Serializable {

   public ArrayList<DonorInformation> donorInformation=new ArrayList<>();


    public ArrayList<DonorInformation> getDonorInformation() {
        return donorInformation;
    }
}
