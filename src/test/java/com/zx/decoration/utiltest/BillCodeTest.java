package com.zx.decoration.utiltest;

import com.zx.decoration.util.billcodeutil.BillCode;
import org.junit.jupiter.api.Test;

public class BillCodeTest {
    @Test
    public void getBillCode() throws Exception {
        String billcode = BillCode.getBillcode("DD");
        System.out.println(billcode);
    }
}
