package com.ctrip.framework.apollo.biz.message;

import com.ctrip.framework.apollo.biz.AbstractUnitTest;
import com.ctrip.framework.apollo.biz.entity.ReleaseMessage;
import com.ctrip.framework.apollo.biz.repository.ReleaseMessageRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Wujun
 */
public class DatabaseMessageSenderTest extends AbstractUnitTest{
  private DatabaseMessageSender messageSender;
  @Mock
  private ReleaseMessageRepository releaseMessageRepository;

  @Before
  public void setUp() throws Exception {
    messageSender = new DatabaseMessageSender();
    ReflectionTestUtils.setField(messageSender, "releaseMessageRepository", releaseMessageRepository);
  }

  @Test
  public void testSendMessage() throws Exception {
    String someMessage = "some-message";
    ArgumentCaptor<ReleaseMessage> captor = ArgumentCaptor.forClass(ReleaseMessage.class);

    messageSender.sendMessage(someMessage, Topics.APOLLO_RELEASE_TOPIC);

    verify(releaseMessageRepository, times(1)).save(captor.capture());
    assertEquals(someMessage, captor.getValue().getMessage());
  }

  @Test
  public void testSendUnsupportedMessage() throws Exception {
    String someMessage = "some-message";
    String someUnsupportedTopic = "some-invalid-topic";

    messageSender.sendMessage(someMessage, someUnsupportedTopic);

    verify(releaseMessageRepository, never()).save(any(ReleaseMessage.class));
  }
}
