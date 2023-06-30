package com.hungdinh.mathutil.core;

import static com.hungdinh.mathutil.core.MathUtil.*;
import static org.junit.jupiter.api.Assertions.*;
//import static là những hàm dành riêng cho hàm static
//gọi hàm bỏ qua tên class
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MathUtilTest {

    //Chơi DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này
    //vào trong câu lệnh kiểm thử
    
    //chuẩn bị bộ data
    public static Object[][] initData() {
        return new Integer[][]{
            {1,1},{2,2},{5,120},{6,720}
        };
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData") 
    //tên hàm cung cấp data, ngầm định thứ tự 
    //của các phần tử mảng, map vào tham số hàm
    public void testGetFactorialGivenRightArgReturnsWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }

    //Bắt ngoạt lệ khi đưa data tào lao
    @Test
    public void testGetFactorialGivenWrongArgReturnsWell() {
        //xài biểu thức lamda
        //hàm nhận tham số thứ 2 là 1 cái object/có code implement cái
        //functional interface tên là Executable - có 1 hàm không code
        //tên là execute()
        //chơi chậm
//        Executable exObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        };
//        

        //Executable exObject = () -> {getFactorial(-5);};
        //Executable exObject = () -> getFactorial(-5);

        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
    }

}
