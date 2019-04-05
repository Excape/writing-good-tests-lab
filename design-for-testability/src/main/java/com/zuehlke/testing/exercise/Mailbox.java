package com.zuehlke.testing.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mailbox {

    private List<Mail> mails = new ArrayList<>();
    private UserRepository userRepository;

    @Deprecated
    public Mailbox(String userId) {
        List<Mail> mails = retrieveMails(userId);
        this.mails = filterSpamMails(mails);
    }

    private List<Mail> retrieveMails(String userId) {
        return new MailServer().getMail(new UserRepository().getUser(userId));
    }

    public Mailbox(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Mail> filterSpamMails(List<Mail> userMails) {
        return userMails.stream()
                .filter(mail -> mail.isNotSpam() || userRepository.isSafeSender(mail.getFrom()))
                .collect(Collectors.toList());
    }

    class MailServer {

        List<Mail> getMail(User user) {
            return new ArrayList<>();
        }

        void sendMail(Mail mail) {
            mail.setDate(System.currentTimeMillis());
        }
    }

    class User {
    }

    class UserRepository {
        User getUser(String userId) {
            return null;
        }

        public boolean isSafeSender(String from) {
            return true;
        }
    }


    class Mail {
        void setDate(long currentDate) {
        }

        String getFrom() {
            return "";
        }

        String getSubject() {
            return "";
        }

        private boolean isNotSpam() {
            String subject = getSubject();
            return !subject.contains("Junk")
                    && !subject.contains("Spam")
                    && !subject.contains("Advertisment")
                    && !subject.contains("Ads");
        }
    }
}
