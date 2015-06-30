package org.ovirt.engine.api.restapi.resource;

import org.junit.Test;
import org.ovirt.engine.api.model.HostDevice;
import org.ovirt.engine.api.restapi.utils.HexUtils;
import org.ovirt.engine.core.common.action.VdcActionType;
import org.ovirt.engine.core.common.action.VmHostDevicesParameters;

import java.util.Arrays;

public class BackendVmHostDeviceResourceTest
        extends AbstractBackendHostDevicesResourceTest<BackendVmHostDeviceResource> {

    public BackendVmHostDeviceResourceTest() {
        super(new BackendVmHostDeviceResource(HexUtils.string2hex(DEVICE_NAME), new BackendVmHostDevicesResource(VM_ID)));
    }

    @Override
    protected void init() {
        super.init();
        initResource(resource.getParent());
    }

    @Test
    public void testGet() {
        setUpGetVmHostDevicesExpectations();

        control.replay();

        HostDevice device = resource.get();
        verifyHostDevice(device);
    }

    @Test
    public void testRemove() {
        setUriInfo(setUpBasicUriExpectations());
        setUpGetVmHostDevicesExpectations();
        setUpActionExpectations(
                VdcActionType.RemoveVmHostDevices,
                VmHostDevicesParameters.class,
                new String[] { "VmId", "DeviceNames" },
                new Object[] { VM_ID, Arrays.asList(DEVICE_NAME) },
                true, true);

        verifyRemove(resource.remove());
    }
}