package uz.pdp.jpa_app2.cantroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.jpa_app2.entity.Phone;
import uz.pdp.jpa_app2.repositary.PhoneRepozitary;

import java.util.List;
import java.util.Optional;

@RestController
public class PhoneController {
    final
    PhoneRepozitary phoneRepozitary;
    @Autowired
    public PhoneController(PhoneRepozitary phoneRepozitary) {
        this.phoneRepozitary = phoneRepozitary;
    }


    @RequestMapping(value = "/phone",method = RequestMethod.GET)
    public List<Phone> getPhones(){
        return phoneRepozitary.findAll();
    }
    @RequestMapping(value = "/phone/{id}",method = RequestMethod.GET)
    public Phone getPhone(@PathVariable Integer id){
        Optional<Phone> optionalPhone = phoneRepozitary.findById(id);
        return optionalPhone.orElse(null);

    }
    @RequestMapping(value = "/phone",method = RequestMethod.POST)
    public String AddPhone(@RequestBody Phone phone){
        List<Phone> allphone = phoneRepozitary.findAll();
//        boolean equals = allphone.stream().map(Phone::getMacAddress).equals(phone.getMacAddress());
//        System.out.println(equals);
        boolean ishas = false;
        for (Phone phone1 : allphone) {
            if (phone.getMacAddress().equals(phone1.getMacAddress())) {
                ishas = true;
                break;
            }
        }
        if (ishas){
            return "bunday macAddressli Phone Mavjud";
        }else{
            phoneRepozitary.save(phone);
            return "ADD phone";
        }
    }


    @RequestMapping(value = "/phone/{id}",method = RequestMethod.PUT)
    public String editPhone(@PathVariable Integer id,@RequestBody Phone phone){
        Optional<Phone> phoneOptional = phoneRepozitary.findById(id);
        Phone phoneEdit = phoneOptional.get();
        boolean ishas = false;
        List<Phone> editPhoneList = phoneRepozitary.findAll();
        for (Phone phone1 : editPhoneList) {
            if (phone.getMacAddress().equals(phone1.getMacAddress())) {
                ishas = false;
                break;
            }else {
                ishas = true;
            }
        }
        if (ishas){

            phoneEdit.setInfo(phone.getInfo());
            phoneEdit.setMacAddress(phone.getMacAddress());
            phoneEdit.setName(phone.getName());
            phoneEdit.setModel(phone.getModel());
            phoneRepozitary.save(phoneEdit);
            return "Phone Edited";
         }else {
            return "Macaddresi li phone mavjud";

         }
    }
    @RequestMapping(value = "/phone/{id}",method = RequestMethod.DELETE)
    public String Deletedphone(@PathVariable Integer id){
        List<Phone> deletlist = phoneRepozitary.findAll();
        boolean ihas = false;
        for (Phone phone : deletlist) {
            if (id == phone.getId()){
                ihas = true;
                break;
            }
        }
        if (!ihas){
            return "Bunday telefon bazada mavjud emas";
        }else {
            phoneRepozitary.deleteById(id);
            return "Phone deleted";
        }
    }
}
