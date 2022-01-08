package com.github.jakobwilms.weatherdb.fx;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.jetbrains.annotations.NotNull;

public class FXVar {
    public static final java.awt.Dimension SCREEN_SIZE = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public static final int PARTS_CONSTRAINTS = 12;
    public static final int MUL_CONSTRAINTS = PARTS_CONSTRAINTS - 2;
    public static final int VBOX_SPACING = 5;

    public static final int TILE_WIDTH_SINGLE_VIEW = Math.toIntExact(Math.round(SCREEN_SIZE.width / 2.5));
    public static final int TILE_HEIGHT_SINGLE_VIEW = Math.toIntExact(Math.round(SCREEN_SIZE.height / 2.5));


    public static final int TILE_WIDTH_MENU = Math.toIntExact(Math.round(SCREEN_SIZE.width / 8.0));
    public static final int TILE_WIDTH_TIME = Math.toIntExact(Math.round((SCREEN_SIZE.width - TILE_WIDTH_MENU) / 6.0));
    public static final int TILE_WIDTH_TIME_VIEW = Math.toIntExact(Math.round((SCREEN_SIZE.width - TILE_WIDTH_MENU) / 3.5));
    public static final int STACK_PANE_CONSTRAINTS_WIDTH = (int) ((float) (SCREEN_SIZE.width - TILE_WIDTH_MENU) / PARTS_CONSTRAINTS);
    public static final int TILE_WIDTH_ALONE = STACK_PANE_CONSTRAINTS_WIDTH * MUL_CONSTRAINTS;
    public static final int TILE_WIDTH_OVERVIEW = Math.toIntExact(Math.round(STACK_PANE_CONSTRAINTS_WIDTH * 1.6));
    public static final int TILE_HEIGHT_MENU = Math.toIntExact(Math.round(SCREEN_SIZE.height / 15.0));
    public static final int TILE_HEIGHT_TIME = Math.toIntExact(Math.round(TILE_HEIGHT_MENU * 1.5));
    public static final int TILE_HEIGHT_TIME_VIEW = Math.toIntExact(Math.round((SCREEN_SIZE.height - TILE_HEIGHT_TIME) / 2.5));
    public static final int STACK_PANE_CONSTRAINTS_HEIGHT = (int) ((float) (SCREEN_SIZE.height - TILE_HEIGHT_MENU) / PARTS_CONSTRAINTS);
    public static final int TILE_HEIGHT_ALONE = STACK_PANE_CONSTRAINTS_HEIGHT * MUL_CONSTRAINTS;
    public static final int TILE_HEIGHT_OVERVIEW = Math.toIntExact(Math.round(STACK_PANE_CONSTRAINTS_HEIGHT * 2));

    public static final @NotNull Color SCENE_BACKGROUND_COLOR = Color.web("#101214");
    public static final @NotNull Color SCENE_BACKGROUND_COLOR_BRIGHTER = Color.web("#202224");
    public static final @NotNull Color TIME_BORDER_COLOR = Color.web("#404244");
    public static final @NotNull Color MENU_BUTTON_BACKGROUND_COLOR = Color.web("#303030");
    public static final @NotNull Color MENU_BUTTON_COLOR_DARK = Color.web("#1c519f");
    public static final @NotNull Color MENU_BUTTON_COLOR_LIGHT = Color.web("#5c91df");
    public static final @NotNull Color WELCOME_BORDER_COLOR = Color.web("#D0D0FF");

    public static final @NotNull Background SCENE_BACKGROUND = new Background(
            new BackgroundFill(SCENE_BACKGROUND_COLOR, CornerRadii.EMPTY, Insets.EMPTY));
    public static final @NotNull Background SCENE_BACKGROUND_BRIGHTER = new Background(
            new BackgroundFill(SCENE_BACKGROUND_COLOR_BRIGHTER, CornerRadii.EMPTY, Insets.EMPTY));
    public static final @NotNull Background MENU_BUTTON_BACKGROUND = new Background(
            new BackgroundFill(MENU_BUTTON_BACKGROUND_COLOR, CornerRadii.EMPTY, Insets.EMPTY));

    public static final @NotNull Border TILE_BORDER = new Border(
            new BorderStroke(TIME_BORDER_COLOR, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, new BorderWidths(2)));
    public static final @NotNull Border MENU_BUTTON_BORDER_DARK = new Border(
            new BorderStroke(MENU_BUTTON_COLOR_DARK, BorderStrokeStyle.DASHED, new CornerRadii(2), new BorderWidths(2)));
    public static final @NotNull Border MENU_BUTTON_BORDER_LIGHT = new Border(
            new BorderStroke(MENU_BUTTON_COLOR_LIGHT, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(2)));
    public static final @NotNull Border WELCOME_BORDER = new Border(
            new BorderStroke(WELCOME_BORDER_COLOR, BorderStrokeStyle.DASHED, new CornerRadii(6), new BorderWidths(2)));
}
