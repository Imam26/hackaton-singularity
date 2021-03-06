package com.bagzat.tournament;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)
public class ControllersTest {
//    public ControllersTest() {
//    }
//
//    private MockMvc tournamentMockMvc;
//    private MockMvc matchMockMvc;
//    private MockMvc participantMockMvc;
//
//    @InjectMocks
//    private TournamentController tournamentController;
//    @InjectMocks
//    private MatchController matchController;
//    @InjectMocks
//    private ParticipantController participantController;
//
//    void fillDatabase() throws Exception {
//        Tournament tournament = new Tournament(16, 6);
//        tournamentMockMvc.perform(
//                post("/tournaments", tournament)
//        )
//                .andExpect(status().isOk());
//
//        for (int i = 0; i < 13; ++i) {
//            Participant participant = new Participant((long) (i + 1), "user" + (i + 1));
//
//            participantMockMvc.perform(
//                    post("/tournaments/1/participants", participant)
//            )
//                    .andExpect(status().isOk());
//        }
//    }
//
//    @BeforeEach
//    void setUp() throws Exception {
//        tournamentMockMvc = MockMvcBuilders.standaloneSetup(tournamentController).build();
//        matchMockMvc = MockMvcBuilders.standaloneSetup(matchController).build();
//        participantMockMvc = MockMvcBuilders.standaloneSetup(participantController).build();
//
//        fillDatabase();
//    }
//
//    @Test
//    public void testGetTournament() throws Exception {
//        tournamentMockMvc.perform(
//                get("/tournaments/1")
//        )
//                .andExpect(status().isOk());
//    }

//    @Test
//    public void testGet() throws Exception {
//        tournamentMockMvc.perform(
//                post("/tournaments")
//        )
//                .andExpect(status().isMethodNotAllowed())
//                .andExpect(content().string("Hello world!"));
//    }
//
//    @Test
//    public void testJSON() throws Exception {
//        tournamentMockMvc.perform(
//                MockMvcRequestBuilders.get("/tournaments")
//                        .accept(MediaType.APPLICATION_JSON)
//        )
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title", Matchers.is("Greetings")))
//                .andExpect(jsonPath("$.value", Matchers.is("Hello world!")));
//    }
}
