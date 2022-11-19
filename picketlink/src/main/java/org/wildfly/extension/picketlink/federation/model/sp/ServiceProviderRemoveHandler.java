/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.wildfly.extension.picketlink.federation.model.sp;

import org.jboss.as.controller.AbstractRemoveStepHandler;
import org.jboss.as.controller.OperationContext;
import org.jboss.as.controller.OperationFailedException;
import org.jboss.as.controller.PathAddress;
import org.jboss.as.controller.descriptions.ModelDescriptionConstants;
import org.jboss.dmr.ModelNode;
import org.wildfly.extension.picketlink.federation.service.ServiceProviderService;

import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.ADDRESS;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 */
public class ServiceProviderRemoveHandler extends AbstractRemoveStepHandler {

    public static final ServiceProviderRemoveHandler INSTANCE = new ServiceProviderRemoveHandler();

    private ServiceProviderRemoveHandler() {
    }

    @Override
    protected void performRuntime(OperationContext context, ModelNode operation, ModelNode model)
            throws OperationFailedException {
        String spAlias = PathAddress.pathAddress(operation.get(ModelDescriptionConstants.ADDRESS)).getLastElement().getValue();
        context.removeService(ServiceProviderService.createServiceName(spAlias));
    }

    @Override
    protected void recoverServices(OperationContext context, ModelNode operation, ModelNode model) throws OperationFailedException {
        ServiceProviderAddHandler.launchService(context, PathAddress.pathAddress(operation.get(ADDRESS)), model);
    }
}