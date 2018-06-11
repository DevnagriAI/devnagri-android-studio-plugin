package com.devnagri.androidstudio.helper;

import com.devnagri.androidstudio.ui.ColorTextPane;
import com.devnagri.androidstudio.ui.ToolWindowPane;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;
import org.jetbrains.annotations.Nullable;


public class ToolWindowHelper {

    private final ToolWindow outputWindow;

    public ToolWindowHelper(Project project){
        outputWindow = ToolWindowManager.getInstance(project).getToolWindow("Devnagri");
    }

    @Nullable
    public ColorTextPane getColorTextPane() {
        final Content content = outputWindow.getContentManager().getContent(0);

        if (content != null) {
            ToolWindowPane pane = (ToolWindowPane) content.getComponent();
            return pane.getOutputTextArea();

        }
        return null;
    }

    public ToolWindow getOutputWindow() {
        return outputWindow;
    }
}
