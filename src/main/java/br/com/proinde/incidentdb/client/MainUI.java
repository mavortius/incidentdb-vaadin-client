package br.com.proinde.incidentdb.client;

import br.com.proinde.incidentdb.client.domain.Incident;
import br.com.proinde.incidentdb.client.domain.Trader;
import br.com.proinde.incidentdb.client.service.IncidentService;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Map;
import java.util.stream.Collectors;

@SpringUI
@Theme(ValoTheme.THEME_NAME)
public class MainUI extends UI {

    private final IncidentService service;

    public MainUI(IncidentService service) {
        this.service = service;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Grid<Incident> grid = new Grid<>();

        grid.setSizeFull();
        grid.setDataProvider(
                (sortOrders, offset, limit) -> {
                    Map<String, Boolean> sortOrder = sortOrders.stream()
                            .collect(Collectors.toMap(
                                    sort -> sort.getSorted(),
                                    sort -> sort.getDirection() == SortDirection.ASCENDING));
                    return service.findAll(offset, limit, sortOrder).stream();
                },
                () -> service.count()
        );
        grid.addColumn(Incident::getReference);
        grid.asSingleSelect().addValueChangeListener(e -> {
            Notification.show(e.getValue().toString());
        });

        VerticalLayout mainLayout = new VerticalLayout(grid);

        mainLayout.setSizeFull();
        setContent(mainLayout);
    }
}
