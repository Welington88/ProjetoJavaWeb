package br.com.upabicasreal.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.upabicasreal.mb.LoginBean;

public class Autorizador implements PhaseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void beforePhase(PhaseEvent event) {
	}

	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		if ("/login.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}

		// Obtendo LoginBean da sess�o
		LoginBean loginBean = context.getApplication().evaluateExpressionGet(
				context, "#{loginBean}", LoginBean.class);
		if (!loginBean.isUsuarioLogado()) {
			NavigationHandler handler = context.getApplication()
					.getNavigationHandler();
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			context.renderResponse();
		}

	}
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
}
