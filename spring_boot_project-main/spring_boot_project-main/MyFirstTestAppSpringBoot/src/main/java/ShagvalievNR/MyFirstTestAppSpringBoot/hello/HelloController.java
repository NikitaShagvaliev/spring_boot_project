package ShagvalievNR.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class HelloController {

    private List<String> arrayList = new ArrayList<>();
    private Map<Integer, String> hashMap = new HashMap<>();

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
            defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    // 1. Метод для обновления ArrayList
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "value") String value) {
        arrayList.add(value);  // добавляем значение в ArrayList
        return "Значение, добавленное в ArrayList: " + value;
    }

    // 2. Метод для отображения содержимого ArrayList
    @GetMapping("/show-array")
    public List<String> showArrayList() {
        return arrayList;  // возвращаем все элементы в ArrayList
    }

    // 3. Метод для обновления HashMap
    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "value") String value) {
        int key = hashMap.size();  // создаем ключ на основе текущего размера HashMap
        hashMap.put(key, value);  // добавляем значение в HashMap
        return "Значение, добавленное к HashMap: " + value + " с ключом " + key;
    }

    // 4. Метод для отображения содержимого HashMap
    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        return hashMap;  // возвращаем все элементы в HashMap
    }

    // 5. Метод для отображения количества элементов в ArrayList и HashMap
    @GetMapping("/show-all-length")
    public String showAllLength() {
        return String.format("Количество эдементов ArrayList: %d, HashMap size: %d", arrayList.size(), hashMap.size());
    }
}