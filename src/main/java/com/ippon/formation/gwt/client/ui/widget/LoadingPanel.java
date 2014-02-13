package com.ippon.formation.gwt.client.ui.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;

public class LoadingPanel extends Composite {

    private static LoadingPanelUiBinder uiBinder = GWT.create(LoadingPanelUiBinder.class);

    private Integer width = 0;

    @UiField
    InlineLabel progressBar;

    interface LoadingPanelUiBinder extends UiBinder<Widget, LoadingPanel> {
    }

    public LoadingPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        launchProgressBar();
    }

    private void launchProgressBar() {
        Timer t = new Timer() {
            @Override
            public void run() {
                if (width == 100) {
                    width = 0;
                }
                else {
                    width++;
                }
                progressBar.setWidth(Integer.toString(width) + "%");
            }
        };

        t.scheduleRepeating(25);
    }
}
