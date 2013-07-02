import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.canvas.dom.client.CssColor;
//import com.google.gwt.uibinder.client.UiConstructor;

/*
*	A GWT Progress Bar using HTML5 canvas API.
*
*/

public class ProgressBar2{
	
	static final int width = 300;
	static final int height = 40;
	static final double barWidth = 120;
	static final double barheight = 20;

	Canvas canvas;
	Context2d context;
	

	public ProgressBar2(int min,int max,VerticalPanel resultPanel){
		canvas=canvas.createIfSupported();
		if(canvas==null){
			resultPanel.add(new Label("Canvas is null"));
		}
		
		canvas.setWidth(width + "px");
		canvas.setHeight(height + "px");
		canvas.setCoordinateSpaceWidth(width);
		canvas.setCoordinateSpaceHeight(height);

		double p = (double)min/max;		//vote percentage
		double fillWidth = p*((barWidth/2)/50);
		context=canvas.getContext2d();

		resultPanel.add(canvas);

		//context.beginPath();
		context.rect(0,0,barWidth,barheight);
		context.setFillStyle(CssColor.make("blue"));
		
		context.fillRect(0,0,fillWidth,barheight);	
		context.setLineWidth(2);
		context.setStrokeStyle(CssColor.make("black"));
		context.stroke();
		//context.closePath();
		context.setFont("italic 14pt Calibri");
		context.setFillStyle(CssColor.make("black"));
		context.fillText((int)p+"% votes",barWidth+5,barheight);
	}
}
