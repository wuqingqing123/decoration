package com.zx.decoration.util.billcodeutil;


import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author wqq
 */
public class BillCode {
    private static Logger log = LogManager.getLogger(BillCode.class);
    public static String getBillcode(String prefix) throws Exception {
        String billcode = null;
        try {
            JSONObject retObj = RequestUtils.getJSON("http://39.96.0.70/billcode", null, null);
            if (retObj.getInt("code") == 200) {
                billcode = prefix + retObj.getString("message").trim();
            } else {
                throw new Exception("单据号获取失败");
            }
        } catch (Exception e) {
            log.error("单据号获取错误！", e);
            throw e;
        }
        return billcode;

    }
}
