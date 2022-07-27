package com.connector.beta.mapper;

import com.connector.beta.dto.ChatNotificationDto;
import com.connector.beta.dto.UserDto;
import com.connector.beta.entities.MyUser;
import com.connector.beta.websocketEntities.ChatMessage;
import com.connector.beta.websocketEntities.ChatNotification;
import com.connector.beta.websocketdto.ChatMessageDto;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-03T16:45:28+0000",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public MyUser map(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        MyUser myUser = new MyUser();

        myUser.setUserId( userDto.getUserId() );
        myUser.setEmail( userDto.getEmail() );
        myUser.setFirstName( userDto.getFirstName() );
        myUser.setLastName( userDto.getLastName() );
        myUser.setBirthday( userDto.getBirthday() );

        return myUser;
    }

    @Override
    public UserDto mapToDto(MyUser user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserId( user.getUserId() );
        userDto.setEmail( user.getEmail() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        if ( user.getBirthday() != null ) {
            userDto.setBirthday( new Date( user.getBirthday().getTime() ) );
        }

        return userDto;
    }

    @Override
    public List<UserDto> mapListToDto(List<MyUser> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( MyUser myUser : users ) {
            list.add( mapToDto( myUser ) );
        }

        return list;
    }

    @Override
    public ChatNotificationDto mapToChatNotificationDto(ChatNotification chatNotification) {
        if ( chatNotification == null ) {
            return null;
        }

        ChatNotificationDto chatNotificationDto = new ChatNotificationDto();

        Integer userId = chatNotificationSenderNotificationUserId( chatNotification );
        if ( userId != null ) {
            chatNotificationDto.setUserId( String.valueOf( userId ) );
        }
        chatNotificationDto.setFirstName( chatNotificationSenderNotificationFirstName( chatNotification ) );
        chatNotificationDto.setLastName( chatNotificationSenderNotificationLastName( chatNotification ) );
        chatNotificationDto.setChatNotificationId( chatNotification.getChatNotificationId() );

        return chatNotificationDto;
    }

    @Override
    public ChatMessageDto chatMessageToDto(ChatMessage message) {
        if ( message == null ) {
            return null;
        }

        ChatMessageDto chatMessageDto = new ChatMessageDto();

        chatMessageDto.setChatMessageId( message.getChatMessageId() );
        chatMessageDto.setSenderId( messageSenderUserId( message ) );
        chatMessageDto.setRecipientId( messageRecipientUserId( message ) );
        chatMessageDto.setContent( message.getContent() );
        chatMessageDto.setTimestamp( message.getCreated() );
        chatMessageDto.setStatus( message.getStatus() );

        return chatMessageDto;
    }

    @Override
    public ChatMessage chatMessageDtoToChatMessage(ChatMessageDto chatMessageDto) {
        if ( chatMessageDto == null ) {
            return null;
        }

        ChatMessage chatMessage = new ChatMessage();

        chatMessage.setChatMessageId( chatMessageDto.getChatMessageId() );
        chatMessage.setContent( chatMessageDto.getContent() );
        chatMessage.setCreated( chatMessageDto.getTimestamp() );
        chatMessage.setStatus( chatMessageDto.getStatus() );

        return chatMessage;
    }

    @Override
    public List<ChatMessageDto> chatMessageToDtos(List<ChatMessage> messages) {
        if ( messages == null ) {
            return null;
        }

        List<ChatMessageDto> list = new ArrayList<ChatMessageDto>( messages.size() );
        for ( ChatMessage chatMessage : messages ) {
            list.add( chatMessageToDto( chatMessage ) );
        }

        return list;
    }

    @Override
    public void updateChatMessageFromDto(ChatMessageDto chatMessageDto, ChatMessage chatMessage) {
        if ( chatMessageDto == null ) {
            return;
        }

        chatMessage.setChatMessageId( chatMessageDto.getChatMessageId() );
        chatMessage.setContent( chatMessageDto.getContent() );
        chatMessage.setStatus( chatMessageDto.getStatus() );
    }

    private Integer chatNotificationSenderNotificationUserId(ChatNotification chatNotification) {
        if ( chatNotification == null ) {
            return null;
        }
        MyUser senderNotification = chatNotification.getSenderNotification();
        if ( senderNotification == null ) {
            return null;
        }
        Integer userId = senderNotification.getUserId();
        if ( userId == null ) {
            return null;
        }
        return userId;
    }

    private String chatNotificationSenderNotificationFirstName(ChatNotification chatNotification) {
        if ( chatNotification == null ) {
            return null;
        }
        MyUser senderNotification = chatNotification.getSenderNotification();
        if ( senderNotification == null ) {
            return null;
        }
        String firstName = senderNotification.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String chatNotificationSenderNotificationLastName(ChatNotification chatNotification) {
        if ( chatNotification == null ) {
            return null;
        }
        MyUser senderNotification = chatNotification.getSenderNotification();
        if ( senderNotification == null ) {
            return null;
        }
        String lastName = senderNotification.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private Integer messageSenderUserId(ChatMessage chatMessage) {
        if ( chatMessage == null ) {
            return null;
        }
        MyUser sender = chatMessage.getSender();
        if ( sender == null ) {
            return null;
        }
        Integer userId = sender.getUserId();
        if ( userId == null ) {
            return null;
        }
        return userId;
    }

    private Integer messageRecipientUserId(ChatMessage chatMessage) {
        if ( chatMessage == null ) {
            return null;
        }
        MyUser recipient = chatMessage.getRecipient();
        if ( recipient == null ) {
            return null;
        }
        Integer userId = recipient.getUserId();
        if ( userId == null ) {
            return null;
        }
        return userId;
    }
}
