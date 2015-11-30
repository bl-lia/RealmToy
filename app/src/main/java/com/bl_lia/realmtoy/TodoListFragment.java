package com.bl_lia.realmtoy;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.Realm;

/**
 * Created by yuki_fn on 11/30/15.
 */
public class TodoListFragment extends Fragment {

    @Bind(R.id.list_todo) RecyclerView mTodoList;

    private TodoAdapter mTodoAdapter;

    public static TodoListFragment newInstance() {
        return new TodoListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_todo_list, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initView() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mTodoList.setLayoutManager(layoutManager);

        mTodoAdapter = new TodoAdapter();
        mTodoList.setAdapter(mTodoAdapter);
    }

    private void initData() {
        final List<Todo> initData = new ArrayList<>();
        initData.add(new Todo(RandomStringUtils.randomAlphanumeric(10), "AAAAA", false));
        initData.add(new Todo(RandomStringUtils.randomAlphanumeric(10), "BBBBB", false));
        initData.add(new Todo(RandomStringUtils.randomAlphanumeric(10), "CCCCC", false));
        initData.add(new Todo(RandomStringUtils.randomAlphanumeric(10), "DDDDD", false));
        initData.add(new Todo(RandomStringUtils.randomAlphanumeric(10), "EEEEE", false));
        initData.add(new Todo(RandomStringUtils.randomAlphanumeric(10), "FFFFF", false));

        final Realm realm = Realm.getInstance(getActivity());
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(Todo.class).findAll().clear();
                realm.copyToRealmOrUpdate(initData);
            }
        });

        if (mTodoAdapter != null) {
            mTodoAdapter.resetTodo(initData);
        }
    }
}
