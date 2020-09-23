# Instructions

## Proposal One

1. Open [pom.xml](./pom.xml).
1. Make sure **7.0.0-beta.10** is referenced.
1. Reload Maven projects.
1. Edit [ReceiverProposalOne.java](./src/main/java/org/example/ReceiverProposalOne.java).

### Testing

1. `useSessions()` toggle with `acceptSession()` and `acceptSession(String)`
    1. Understand if users expect that they'll have to accept a session first.
1. Is it intuitive that calling `acceptSession()` twice will throw an exception if a session is already accepted.
    1. In Proposal Two, we return a no-op if one is accepted.
1. `concurrentSessionReceiver()` to receive from multiple sessions.

## Proposal Two

1. Open [pom.xml](./pom.xml).
1. Make sure **7.0.0-beta.15** is referenced.
1. Reload Maven projects.
1. Edit [ReceiverProposalTwo.java](./src/main/java/org/example/ReceiverProposalTwo.java).


### Testing

1. `useSessions()` and `useSessions(String)` to toggle between first available session receiver, named session receiver, and vanilla receiver.
1. Understand if users expect that they'll have to accept a session first.
1. Is it intuitive that calling `acceptSession()` twice will return a no-op if session is already opened.
1. Is `ServiceBusSessionProcessorClient` easier to receive from multiple sessions.
