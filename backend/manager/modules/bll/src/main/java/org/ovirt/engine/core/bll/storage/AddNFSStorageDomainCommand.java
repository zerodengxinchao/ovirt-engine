package org.ovirt.engine.core.bll.storage;

import org.ovirt.engine.core.bll.context.CommandContext;
import org.ovirt.engine.core.common.action.StorageDomainManagementParameter;
import org.ovirt.engine.core.compat.Guid;

public class AddNFSStorageDomainCommand<T extends StorageDomainManagementParameter> extends AddStorageDomainCommon<T> {

    /**
     * Constructor for command creation when compensation is applied on startup
     *
     * @param commandId
     */
    protected AddNFSStorageDomainCommand(Guid commandId) {
        super(commandId);
    }

    public AddNFSStorageDomainCommand(T parameters) {
        super(parameters);
    }

    public AddNFSStorageDomainCommand(T parameters, CommandContext commandContext) {
        super(parameters, commandContext);
    }
}
