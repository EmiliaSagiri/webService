package top.tocome.webservice.controller.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.tocome.io.File;
import top.tocome.webservice.Account.UserSystem;
import top.tocome.webservice.data.Config;
import top.tocome.webservice.data.Error;
import top.tocome.webservice.data.ResponseData;

import javax.servlet.http.HttpServletRequest;

public class UserCenter {
    public static final Logger logger = LoggerFactory.getLogger("user");
    public static final String savePath2 = Config.dataPath + "users.json";
    public static Error invoke(HttpServletRequest request, ResponseData data) {
        String type = request.getParameter("type");
        logger.info(type);

        switch (type){
            case "get":
                if (!new File(savePath2).exists()) return Error.NoData;
                data.put("user",UserSystem.Instance.getAllUsers());
                return Error.Success;

            default:
                return Error.Failed;
        }
    }
}
