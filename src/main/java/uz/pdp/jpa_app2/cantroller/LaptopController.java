package uz.pdp.jpa_app2.cantroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.jpa_app2.entity.Laptop;
import uz.pdp.jpa_app2.entity.Phone;
import uz.pdp.jpa_app2.repositary.LaptopRepozitary;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    final
    LaptopRepozitary laptopRepozitary;
    @Autowired
    public LaptopController(LaptopRepozitary laptopRepozitary) {
        this.laptopRepozitary = laptopRepozitary;
    }


    @RequestMapping(value = "/laptop",method = RequestMethod.GET)
    public List<Laptop> getLaptops(){
        return laptopRepozitary.findAll();
    }
    @RequestMapping(value = "/laptop/{id}",method = RequestMethod.GET)
    public Laptop getLaptop(@PathVariable Integer id){
        Optional<Laptop> optionalLaptop = laptopRepozitary.findById(id);
        return optionalLaptop.orElse(null);

    }
    @RequestMapping(value = "/laptop",method = RequestMethod.POST)
    public String AddLaptop(@RequestBody Laptop laptop){
        List<Laptop> allLaptop = laptopRepozitary.findAll();
//
        boolean ishas = false;
        for (Laptop laptop1 : allLaptop) {
            if (laptop.getMacaddress().equals(laptop1.getMacaddress())) {
                ishas = true;
                break;
            }
        }
        if (ishas){
            return "bunday macAddressli Laptop  Mavjud";
        }else{
            laptopRepozitary.save(laptop);
            return "ADD laptop";
        }
    }


    @RequestMapping(value = "/laptop/{id}",method = RequestMethod.PUT)
    public String editLaptop(@PathVariable Integer id,@RequestBody Laptop laptop){
        Optional<Laptop> laptopOptional = laptopRepozitary.findById(id);
        Laptop laptop1 = laptopOptional.get();
        boolean ishas = false;
        List<Laptop> editLaptopList = laptopRepozitary.findAll();
        for (Laptop laptop2 : editLaptopList) {
            if (laptop.getMacaddress().equals(laptop2.getMacaddress())) {
                ishas = false;
                break;
            }else {
                ishas = true;
            }
        }
        if (ishas){

            laptop1.setBrandName(laptop.getBrandName());
            laptop1.setModel(laptop.getModel());
            laptop1.setName(laptop.getName());
            laptop1.setRam(laptop.getRam());
            laptop1.setMacaddress(laptop.getMacaddress());
            laptop1.setStrong(laptop.getStrong());
            laptopRepozitary.save(laptop1);
            return "Laptop Edited";
        }else {
            return "Macaddresi li laptop mavjud";

        }
    }
    @RequestMapping(value = "/laptop/{id}",method = RequestMethod.DELETE)
    public String DeletedLaptop(@PathVariable Integer id){
        List<Laptop> deletlist = laptopRepozitary.findAll();
        boolean ihas = false;
        for (Laptop laptop : deletlist) {
            if (id == laptop.getId()){
                ihas = true;
                break;
            }
        }
        if (!ihas){
            return "Bunday laptop bazada mavjud emas";
        }else {
            laptopRepozitary.deleteById(id);
            return "laptop deleted";
        }
    }

}
