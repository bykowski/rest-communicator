package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConnectionEndpoint {

    private HistroyService histroyService;

    @Autowired
    public ConnectionEndpoint(HistroyService histroyService) {
        this.histroyService = histroyService;
    }

    @RequestMapping(value = "/putMessage", method = RequestMethod.PUT)
    @ResponseBody
    public void sentText(@RequestParam("text") String text) {
        histroyService.addHistory(text);
    }
}
