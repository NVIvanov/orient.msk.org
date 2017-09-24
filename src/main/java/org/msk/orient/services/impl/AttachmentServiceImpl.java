package org.msk.orient.services.impl;

import org.msk.orient.domain.entities.Attachment;
import org.msk.orient.domain.repositories.AttachmentRepository;
import org.msk.orient.services.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nivanov
 * on 24.09.17.
 */

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;

    @Autowired
    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public void createAttachment(Attachment attachment) {
        attachmentRepository.save(attachment);
    }
}
