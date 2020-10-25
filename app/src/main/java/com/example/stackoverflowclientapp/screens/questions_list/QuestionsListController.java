package com.example.stackoverflowclientapp.screens.questions_list;

import com.example.stackoverflowclientapp.questions.FetchLastActiveQuestionsUseCase;
import com.example.stackoverflowclientapp.questions.Question;
import com.example.stackoverflowclientapp.screens.common.toastshelper.ToastsHelper;
import com.example.stackoverflowclientapp.screens.common.screensnavigator.ScreensNavigator;

import java.util.List;

public class QuestionsListController implements
        QuestionsListViewMvcImpl.Listener, FetchLastActiveQuestionsUseCase.Listener
{

    private final FetchLastActiveQuestionsUseCase mFetchLastActiveQuestionsUseCase;

    private final ScreensNavigator mScreensNavigator;

    private final ToastsHelper mToastsHelper;

    private QuestionsListViewMvc mViewMvc;
    ;

    public QuestionsListController(FetchLastActiveQuestionsUseCase fetchLastActiveQuestionsUseCase,
                                   ScreensNavigator screensNavigator,
                                   ToastsHelper toastsHelper)
    {
        mFetchLastActiveQuestionsUseCase = fetchLastActiveQuestionsUseCase;
        mScreensNavigator = screensNavigator;
        mToastsHelper = toastsHelper;
    }

    public void bindView(QuestionsListViewMvc viewMvc)
    {
        mViewMvc = viewMvc;
    }

    public void onStart()
    {
        mViewMvc.registerListener(this);
        mFetchLastActiveQuestionsUseCase.registerListener(this);
        mFetchLastActiveQuestionsUseCase.fetchLastActiveQuestionAndNotify();
        mViewMvc.showProgressIndication();
    }

    public void onStop()
    {
        mViewMvc.unregisterListener(this);
        mFetchLastActiveQuestionsUseCase.unregisterListener(this);
    }

    @Override
    public void onQuestionClicked(Question question)
    {
        mScreensNavigator.toDialogDetails(question.getId());
    }

    @Override
    public void onLastActiveQuestionFetched(List<Question> questions)
    {
        mViewMvc.bindQuestions(questions);
        mViewMvc.hideProgressIndication();
    }

    @Override
    public void onLastActiveQuestionFetchFailed()
    {
        mViewMvc.hideProgressIndication();
        mToastsHelper.showUseCaseError();
    }
}
