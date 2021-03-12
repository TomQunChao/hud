package com.a11hud.www.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.a11hud.www.MainActivity;
import com.a11hud.www.R;
import com.a11hud.www.util.SearchResultAdapter;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.ArrayList;
import java.util.List;

public class SearchPointActivity extends Activity implements TextWatcher, Inputtips.InputtipsListener {
    private final int DST_POI_MODE = 1;
    private final int START_POI_MODE = 0;
    private Context context;
    private String curCity;
    private Poi dstPoi = null;
    private AutoCompleteTextView[] keyword;
    private List listPoi = null;
    private ListView listPoint;
    private Poi originPoi;
    private LinearLayout poiType;
    private int pointType = 0;
    private String preCity = null;
    private RadioButton radioCurLoc;
    private RadioGroup radioScope;
    private SearchResultAdapter resultAdapter;
    private Poi selectedPoi = null;
    private List<Tip> tips;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchpoint);
        this.context = this;
        initView();
        initInfo();
        initListener();
    }

    private void initView() {
        this.listPoint = (ListView) findViewById(R.id.list_point);
        this.keyword = new AutoCompleteTextView[]{(AutoCompleteTextView) findViewById(R.id.text_startkeyword), (AutoCompleteTextView) findViewById(R.id.text_dstkeyword)};
        this.radioScope = (RadioGroup) findViewById(R.id.id_radio_scope);
        this.radioCurLoc = (RadioButton) findViewById(R.id.id_radio_curloc);
        this.poiType = (LinearLayout) findViewById(R.id.id_layout_mode);
    }

    private void initInfo() {
        this.curCity = getIntent().getExtras().getString("curCity", null);
        String str = this.curCity;
        this.preCity = str;
        Log.i("Info", str);
    }

    private void initListener() {
        this.radioScope.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /* class com.a11hud.www.activities.SearchPointActivity.AnonymousClass1 */

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (SearchPointActivity.this.radioCurLoc.isChecked()) {
                    SearchPointActivity searchPointActivity = SearchPointActivity.this;
                    searchPointActivity.preCity = searchPointActivity.curCity;
                    return;
                }
                SearchPointActivity.this.preCity = null;
            }
        });
        this.keyword[0].addTextChangedListener(this);
        this.keyword[1].addTextChangedListener(this);
        this.poiType.setOnClickListener(new View.OnClickListener() {
            /* class com.a11hud.www.activities.SearchPointActivity.AnonymousClass2 */

            public void onClick(View v) {
                if (SearchPointActivity.this.keyword[1].isFocused()) {
                    SearchPointActivity.this.pointType = 1;
                } else {
                    SearchPointActivity.this.pointType = 0;
                }
                Log.i("Type", SearchPointActivity.this.pointType + "");
            }
        });
        this.listPoint.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.a11hud.www.activities.SearchPointActivity.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (SearchPointActivity.this.listPoint != null) {
                    Tip tip = (Tip) parent.getItemAtPosition(position);
                    SearchPointActivity.this.selectedPoi = new Poi(tip.getName(), new LatLng(tip.getPoint().getLatitude(), tip.getPoint().getLongitude()), tip.getPoiID());
                    if (!TextUtils.isEmpty(SearchPointActivity.this.selectedPoi.getPoiId())) {
                        PoiSearch.Query query = new PoiSearch.Query(SearchPointActivity.this.selectedPoi.getName(), "", SearchPointActivity.this.preCity);
                        query.setDistanceSort(false);
                        query.requireSubPois(true);
                        PoiSearch poiSearch = new PoiSearch(SearchPointActivity.this.getApplicationContext(), query);
                        poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener() {
                            /* class com.a11hud.www.activities.SearchPointActivity.AnonymousClass3.AnonymousClass1 */

                            @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
                            public void onPoiSearched(PoiResult poiResult, int i) {
                            }

                            @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
                            public void onPoiItemSearched(PoiItem poiItem, int errorCode) {
                                Poi poi;
                                if (errorCode == 1000) {
                                    if (poiItem != null) {
                                        try {
                                            poiItem.getExit();
                                            poiItem.getEnter();
                                        } catch (Throwable e) {
                                            e.printStackTrace();
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                }
                                if (0 != 0) {
                                    poi = new Poi(SearchPointActivity.this.selectedPoi.getName(), null, SearchPointActivity.this.selectedPoi.getPoiId());
                                } else {
                                    poi = SearchPointActivity.this.selectedPoi;
                                }
                                SearchPointActivity.this.keyword[SearchPointActivity.this.pointType].setText(poi.getName());
                                if (SearchPointActivity.this.pointType == 0) {
                                    SearchPointActivity.this.originPoi = poi;
                                    return;
                                }
                                SearchPointActivity.this.dstPoi = poi;
                                Intent intent = new Intent(SearchPointActivity.this, MainActivity.class);
                                intent.putExtra("startPoi", SearchPointActivity.this.originPoi);
                                intent.putExtra("dstPoi", SearchPointActivity.this.dstPoi);
                                SearchPointActivity.this.setResult(0, intent);
                                SearchPointActivity.this.finish();
                            }
                        });
                        poiSearch.searchPOIIdAsyn(SearchPointActivity.this.selectedPoi.getPoiId());
                    }
                }
            }
        });
    }

    @Override // com.amap.api.services.help.Inputtips.InputtipsListener
    public void onGetInputtips(List<Tip> list, int rCode) {
        if (rCode == 1000) {
            this.listPoi = new ArrayList();
            for (Tip tip : list) {
                if (tip.getPoint() != null) {
                    this.listPoi.add(tip);
                }
            }
            List list2 = this.listPoi;
            if (list2 == null || list2.isEmpty()) {
                Toast.makeText(this.context, "没有搜索到结果", 0).show();
                return;
            }
            this.resultAdapter = new SearchResultAdapter(getApplicationContext(), this.listPoi);
            this.listPoint.setAdapter((ListAdapter) this.resultAdapter);
            this.resultAdapter.notifyDataSetChanged();
            return;
        }
        Context context2 = this.context;
        Toast.makeText(context2, "出现错误：" + rCode, 0).show();
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (this.keyword[1].isFocused()) {
            this.pointType = 1;
        } else {
            this.pointType = 0;
        }
        Log.i("Type", this.pointType + "");
        if (s != null && s.toString().length() != 0) {
            Inputtips inputTips = new Inputtips(getApplicationContext(), new InputtipsQuery(s.toString(), this.preCity));
            inputTips.setInputtipsListener(this);
            inputTips.requestInputtipsAsyn();
        }
    }

    public void afterTextChanged(Editable s) {
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }
}
