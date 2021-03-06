/*
 * Copyright 2015 "Henry Tao <hi@henrytao.me>"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.henrytao.recyclerpageradapterdemo.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.henrytao.recyclerpageradapter.RecyclerPagerAdapter;
import me.henrytao.recyclerpageradapterdemo.R;
import me.henrytao.recyclerpageradapterdemo.adapter.PagerAdapter;

public class MainActivity extends BaseActivity {

  @Bind(R.id.toolbar) Toolbar vToolbar;

  @Bind(R.id.view_pager) ViewPager vViewPager;

  private PagerAdapter mPagerAdapter;

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_info:
        startActivity(InfoActivity.newIntent(this));
        return true;
      case R.id.action_donate:
        showDonateDialog();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    setSupportActionBar(vToolbar);

    RecyclerPagerAdapter.DEBUG = true;
    mPagerAdapter = new PagerAdapter();
    vViewPager.setAdapter(mPagerAdapter);
  }
}
