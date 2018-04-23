package app;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class CommunicatorGui extends UI {

    private DialogService dialogService;
    private HistroyService histroyService;

    @Autowired
    public CommunicatorGui(DialogService dialogService, HistroyService histroyService) {
        this.dialogService = dialogService;
        this.histroyService = histroyService;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        TextField textFieldHost = new TextField("Host:");
        TextField textFieldPort = new TextField("Port:");

        VerticalLayout components = new VerticalLayout();
        TextArea textArea = new TextArea();
        TextField textField = new TextField();
        textArea.setValue(histroyService.getHistory());

        Button button = new Button("Send");

        button.addClickListener(clickEvent -> {
            dialogService.sentMessage(textFieldHost.getValue(), textFieldPort.getValue(), textField.getValue());
            histroyService.addHistory(textField.getValue());
            textArea.setValue(histroyService.getHistory());
        });

        components.addComponent(textFieldHost);
        components.addComponent(textFieldPort);

        components.addComponent(textArea);
        components.addComponent(textField);
        components.addComponent(button);
        setContent(components);

        UI ui = UI.getCurrent();
        ui.setPollInterval(1000);
        ui.addPollListener(x -> {
            textArea.setValue(histroyService.getHistory());
        });
    }
}
