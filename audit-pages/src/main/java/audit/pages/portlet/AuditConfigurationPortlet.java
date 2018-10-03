/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package audit.pages.portlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
/**
 * 
 * @author edusaldana
 * Clase que sobreescribe el action edit_company de la clase PortalSettingsPortlet para pintar los valores del CAS y NTLM
 */
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=com_liferay_portal_settings_web_portlet_PortalSettingsPortlet",
				"mvc.command.name=/portal_settings/edit_company",
				"service.ranking:Integer=1000"
		},
		service = MVCActionCommand.class
)
public class AuditConfigurationPortlet extends BaseMVCActionCommand {
	private static final Log _log = LogFactoryUtil.getLog(AuditConfigurationPortlet.class);
	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		String casLoginURL = (String)request.getParameter("cas_loginURL");
		String casLogoutURL = (String)request.getParameter("cas_logoutURL");
		String casServerName = (String)request.getParameter("cas_serverName");
		String casServiceURL = (String)request.getParameter("cas_serviceURL");
		String casNoSuchUserRedirectURL = (String)request.getParameter("cas_noSuchUserRedirectURL");
		String ntlmServicePassword = (String)request.getParameter("ntlm_servicePassword");
		String ntlmServiceAccount = (String)request.getParameter("ntlm_serviceAccount");
		String ntlmDomain = (String)request.getParameter("ntlm_domain");
		String ntlmDomainControllerName = (String)request.getParameter("ntlm_domainControllerName");
		String ntlmDomainController = (String)request.getParameter("ntlm_domainController");
		_log.info("CAS");
		_log.info("--------");
		_log.info("URL de autenticación: "+casLoginURL);
		_log.info("URL de salida: "+casLogoutURL);
		_log.info("Nombre del Servidor: "+casServerName);
		_log.info("URL del servicio: "+casServiceURL);
		_log.info("URL de redireccion de usuario no existente: "+casNoSuchUserRedirectURL);
		_log.info("--------");
		_log.info("NTLM");
		_log.info("--------");
		_log.info("Regulardor del dominio: "+ntlmDomainController);
		_log.info("Nombre del controlador del dominio: "+ntlmDomainControllerName);
		_log.info("Dominio: "+ntlmDomain);
		_log.info("Cuenta del servicio: "+ntlmServiceAccount);
		_log.info("Contraseña del servicio: "+ntlmServicePassword);

	}

	
}