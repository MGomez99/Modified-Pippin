package projectview;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
class ControlPanel implements Observer {
	private JButton stepButton = new JButton("Step");
	private JButton clearButton = new JButton("Clear");
	private JButton runButton = new JButton("Run/Pause");
	private JButton reloadButton = new JButton("Reload");
	private ViewMediator view;

	public ControlPanel(ViewMediator gui) {
		view = gui;
		gui.addObserver(this);
	}

	public JComponent createControlDisplay() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));
		stepButton.addActionListener(e -> view.step());
		panel.add(stepButton);
		clearButton.addActionListener(e -> view.clearJob());
		panel.add(clearButton);
		runButton.addActionListener(e -> view.toggleAutoStep());
		panel.add(runButton);
		reloadButton.addActionListener(e -> view.reload());
		panel.add(reloadButton);

		JSlider slider = new JSlider(5, 1000);
		slider.addChangeListener(e -> view.setPeriod(slider.getValue()));
		panel.add(slider);

		return panel;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		stepButton.setEnabled(view.getCurrentState().getStepActive());
		clearButton.setEnabled(view.getCurrentState().getClearActive());
		runButton.setEnabled(view.getCurrentState().getRunPauseActive());
		reloadButton.setEnabled(view.getCurrentState().getReloadActive());

	}
}
