package audit.pages.portlet;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author edusaldana
 * Se crea un listener implementando la acción LifeCycle para que al visitar cualquier página, añada una traza con la página cargada
 */
@Component(
		immediate = true,
		property = {
				"key=servlet.service.events.post",
				"service.ranking:Integer=1000"
		},
		service = LifecycleAction.class
)
public class AuditPagesPortlet implements LifecycleAction {
	private static final Log _log = LogFactoryUtil.getLog(AuditPagesPortlet.class);
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		HttpServletRequest request = lifecycleEvent.getRequest();
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		String currentUrl = themeDisplay.getURLCurrent();
		_log.info("Se ha visitado la página: "+currentUrl);
	}
}