package com.techacademy;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("dayofweek/{date}") //入力された年月日の数字をdateとする
    public String dispDayOfWeek(@PathVariable String date) {
        String year= date.substring(0,4);
        String month = date.substring(4,6);
        String day = date.substring(6,8);

        Calendar calendar = Calendar.getInstance();
        //String型からint型へキャスト
        calendar.set(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
        case Calendar.SUNDAY: return "Sunday";
        case Calendar.MONDAY: return "Monday";
        case Calendar.TUESDAY: return "Tuesday";
        case Calendar.WEDNESDAY: return "Wednesday";
        case Calendar.THURSDAY: return "Thursday";
        case Calendar.FRIDAY: return "Friday";
        case Calendar.SATURDAY: return "Saturday";
        }
        return "";
    }

    @GetMapping("/plus/{val1}/{val2}")//足し算
    public int calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = val1 + val2;
        return res;
    }

    @GetMapping("/minus/{val1}/{val2}")//引き算
    public int calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = val1 - val2; //整数値と指定がないため、val1>=val2の必要はなし
        return res;
    }

    @GetMapping("/times/{val1}/{val2}")//掛け算
    public int calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = val1 * val2;
        return res;
    }

    @GetMapping("/divide/{val1}/{val2}")//割り算
    public float calcDivide(@PathVariable float val1, @PathVariable float val2) {
        //val1/val2　でval2=0があってはいけないが今回指定なし。
        float res = 0;
        res = val1 / val2;
        return res;
   }
}
