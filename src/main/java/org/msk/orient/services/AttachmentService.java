package org.msk.orient.services;

import org.msk.orient.domain.entities.Attachment;

import javax.validation.constraints.NotNull;

/**
 * @author nivanov
 * on 23.09.17.
 */
public interface AttachmentService {

    /**
     * Creates attachment in system
     * @param attachment attachment to create
     * @throws IllegalArgumentException if file name is invalid
     */
    void createAttachment(@NotNull Attachment attachment);
}
