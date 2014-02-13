package com.ippon.formation.gwt.client.ui.widget;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SelectionChangeEvent.HasSelectionChangedHandlers;
import com.google.gwt.view.client.SingleSelectionModel;
import com.ippon.formation.gwt.client.ui.resources.ApplicationResources;
import com.ippon.formation.gwt.shared.domain.entities.Player;

public class PlayersTable extends CellTable<Player> implements HasSelectionChangedHandlers {

    public PlayersTable() {
        super(15, ApplicationResources.getCellTableCss(), KEY_PROVIDER);
        // Create a CellTable.
        this.setWidth("100%", true);
        // Do not refresh the headers and footers every time the data is updated.
        this.setAutoHeaderRefreshDisabled(true);
        this.setAutoFooterRefreshDisabled(true);

        // Create a Pager to control the table.
        SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
        SimplePager pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
        pager.setDisplay(this);

        // Add a selection model so we can select cells.
        this.setSelectionModel(selectionModel);
        // data provider
        dataProvider.setList(new ArrayList<Player>());
        dataProvider.addDataDisplay(this);
        sortHandler = new ListHandler<Player>(dataProvider.getList());
        // loadingIndicator
        this.setLoadingIndicator(new LoadingPanel());

        // Initialize the columns.
        initTableColumns();
        // sort handler
        this.addColumnSortHandler(sortHandler);
    }

    public void loadingTable() {
        // permet de simuler le chargement de la grid
        this.setRowCount(1, true);
        this.setVisibleRangeAndClearData(this.getVisibleRange(), true);
    }

    /**
     * Add the columns to the table.
     */
    private void initTableColumns() {

        Column<Player, String> nameColumn = new Column<Player, String>(new TextCell()) {
            @Override
            public String getValue(Player object) {
                return object.getName();
            }
        };
        this.addColumn(nameColumn, ApplicationResources.getMessages().cell_player_name());

        Column<Player, Number> atpPointColumn = new Column<Player, Number>(new NumberCell()) {
            @Override
            public Integer getValue(Player object) {
                return object.getAtpPoint();
            }
        };
        atpPointColumn.setDefaultSortAscending(false);
        sortHandler.setComparator(atpPointColumn, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getAtpPoint().compareTo(o2.getAtpPoint());
            }
        });
        this.addColumn(atpPointColumn, ApplicationResources.getMessages().cell_player_atpPoint());
        // sort column
        this.getColumnSortList().push(atpPointColumn);
    }

    /**
     * The key provider that provides the unique ID of a contact.
     */
    public static final ProvidesKey<Player> KEY_PROVIDER = new ProvidesKey<Player>() {
        @Override
        public Object getKey(Player item) {
            return item == null ? null : item.getName();
        }
    };

    public static final SingleSelectionModel<Player> selectionModel = new SingleSelectionModel<Player>(KEY_PROVIDER);

    ListDataProvider<Player> dataProvider = new ListDataProvider<Player>(KEY_PROVIDER);

    // init des tris sur les colonnes
    ListHandler<Player> sortHandler;

    @Override
    public HandlerRegistration addSelectionChangeHandler(Handler handler) {
        return selectionModel.addSelectionChangeHandler(handler);
    }

    public Player getSelectedItem() {
        return selectionModel.getSelectedObject();
    }

    public void setData(List<Player> players) {
        dataProvider.getList().clear();
        dataProvider.getList().addAll(players);
        dataProvider.refresh();
        ColumnSortEvent.fire(this, this.getColumnSortList());
    }
}
