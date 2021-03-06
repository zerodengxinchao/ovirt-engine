/*
* Copyright (c) 2010 Red Hat, Inc.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*           http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.ovirt.engine.api.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.ovirt.engine.api.model.InstanceType;
import org.ovirt.engine.api.model.NIC;
import org.ovirt.engine.api.model.Nics;

@Produces({ApiMediaType.APPLICATION_XML, ApiMediaType.APPLICATION_JSON, ApiMediaType.APPLICATION_X_YAML})
public interface InstanceTypeResource extends UpdatableResource<InstanceType>, AsynchronouslyCreatedResource {

    @DELETE
    public Response remove();

    @Path("nics")
    public DevicesResource<NIC, Nics> getNicsResource();

    @Path("watchdogs")
    public WatchdogsResource getWatchdogsResource();

    @Path("graphicsconsoles")
    public GraphicsConsolesResource getGraphicsConsolesResource();

}
