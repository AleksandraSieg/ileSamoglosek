package pl.madison.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.madison.domain.Slowo;

import java.util.Map;

@Controller
public class TestController {
    private char[] samogloski = {'a', 'e', 'i', 'o', 'u', 'y'};

    @RequestMapping(value = "/wstawSlowo")
    public String wstaw(Map<String, Object> model){
        model.put("wstawianie", new Slowo());
        return "wstawianie";
    }

    @RequestMapping(value = "/policzone", method = RequestMethod.POST)
    public String policzone(Slowo slowo, Map<String, Object> model){
        String wyraz = slowo.getNazwa();
        char[] litery = wyraz.toCharArray();
        int licznik = 0;

        for(int i = 0; i<samogloski.length; i++){
            for(int k = 0; k<litery.length; k++){
                if(litery[k]==samogloski[i]){
                    licznik++;
                }
            }
        }

        model.put("obliczone", licznik);

        return "wynik";

    }
}
